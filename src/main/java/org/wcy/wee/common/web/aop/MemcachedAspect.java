package org.wcy.wee.common.web.aop;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.wcy.wee.common.web.util.MemcachedUtil;

import com.whalin.MemCached.MemCachedClient;

/**
 * memcached缓存切面
 * 	将业务数据存放memcached,实现方式：
 * 		1.通过aop环绕通知对get,load,query等请求进行拦截
 * 			1.1从memcached中通过key取值，如果没有值，则进入service调用对应方法查询数据，并将查询结果存放到memcached。
 * 			1.2如果从memcached中获取到值，则直接返回结果，不再进入service查询.
 * 				其中memcached中存放的key规则为：包名+ 类名 + 方法名 + 参数(多个)（参数转换为json）
 * 		2.通过aop后置通知对add,update,remove等请求进行拦截
 * 			即执行完service方法后，通过该拦截，将该包名+ 类名开头的key全部从memcached中清除
 * 
 * @author wcyong
 *
 * @date   2015年10月9日
 */
public class MemcachedAspect {

	@Autowired
	private MemCachedClient memCachedClient;
	
	//失效时间,秒
	public static final int EXPIRETIME = 360000;
	
	public int expiretime = EXPIRETIME;
	
	/**
	 * 环绕方法
	 * @param pjp
	 * @return
	 * @throws Throwable 
	 */
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		String cacheKey = getCacheKey(pjp);
		
		//如果memcached连不上
		if(memCachedClient.stats().isEmpty()) {
			System.out.println("Memcached服务器可能不存在或是连接不上");
			//执行service方法
			return pjp.proceed();
		}
		
		//如果memcached中查询不到
		if(memCachedClient.get(cacheKey) == null) {
			//执行service方法
			Object processd = pjp.proceed();
			//将执行结果存放到memcached中
			memCachedClient.set(cacheKey, processd, expiretime);
		}
		return memCachedClient.get(cacheKey);
	}
	
	/**
	 * 后置通过，数据变更之后，清理缓存数据
	 * @param jp
	 * @throws UnsupportedEncodingException 
	 */
	public void afterMethod(JoinPoint jp) throws UnsupportedEncodingException {
		//包名+ 类名 
		String packageName = jp.getTarget().getClass().getName();
		//包名+ 类名开头的都清理掉
		Map<String, Object> map = MemcachedUtil.getKeysForMap(memCachedClient);
		//遍历
		for(String key : map.keySet()) {
			if(key.startsWith(packageName)) {
				//清理缓存
				memCachedClient.delete(key);
			}
		}
	}

	/**
	 * 生成缓存key
	 * 	通过包名+ 类名 + 方法名 + 参数(多个)生成key
	 * @param pjp
	 * @return
	 */
	private String getCacheKey(ProceedingJoinPoint pjp) {
		StringBuilder sb = new StringBuilder();
		//包名+ 类名
		String packageName = pjp.getTarget().getClass().getName();
		sb.append(packageName);
		
		//方法名
		String methodName = pjp.getSignature().getName();
		sb.append(".").append(methodName);
		
		//参数
		Object[] args = pjp.getArgs();
		
		//将参数转换为json
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		
		for(Object arg : args){
			//流
			StringWriter str = new StringWriter(); 
			//对象转Json写的过程     Json是字符串流
			try {
				om.writeValue(str, arg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb.append(".").append(str);
		}
		
		return sb.toString();
	}


	public void setExpiretime(int expiretime) {
		this.expiretime = expiretime;
	}
	
}
