package org.wcy.wee.log.aop;

import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.wcy.wee.common.util.CodeUtil;
import org.wcy.wee.common.util.JsonUtil;
import org.wcy.wee.log.model.Logs;
import org.wcy.wee.log.service.LogsService;

/**
 * 记录日志的切面
 * 	只记录增、删、改等方法， 不记录查询操作
 * 
 * 在日志数据量大的时候，按月分表存储
 * 		通过定时任务创建表，再根据月份取不同的表
 * 
 * @author wcyong
 *
 * @date   2015年9月6日
 */
@Configuration
@EnableAspectJAutoProxy
@Aspect
@Component
public class LogAspect {
	
	@Autowired
	private LogsService logsService;
	/*@Autowired
	private HttpSession session;*/

	/**
	 * 切入点：表示在哪个类的哪个方法进行切入
	 * 使用@Pointcut来声明切入点表达式,后面的通知直接使用方法名来引用当前的切入点表达式
	 * 将logs本身的添加等排除
	 */
	@Pointcut("(execution(* org.wcy.wee..service.impl..save*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..add*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..insert*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..batch*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..delete*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..remove*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..clear*(..)) || "
			+ "execution(* org.wcy.wee..service.impl..update*(..))) && "
			+ "!bean(logsServiceImpl)")
	public void pointcutExpression() {
	}
	
	/**
	 * 记录日志
	 * 
	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
	 * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
	 * @return
	 */
	@Around("pointcutExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Logs logs = new Logs();
		try {
			//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			//TODO
			//从session中获取登录用户，将操作人设置为 用户id:登录帐号 的格式
			//session.getAttribute("loginUser");
			//String loginId = session.getId();
			logs.setId(CodeUtil.uuid());
			//设置操作人
			//logs.setOperator(loginId);
			String methodName = pjp.getSignature().getName();
			String clzName = pjp.getTarget().getClass().getSimpleName();
			//操作名称,类名称.方法名
			logs.setOperName(clzName + "." +methodName);
			//操作参数
			Object[] args = pjp.getArgs();
			//将参数转换为json格式存入到数据库中
			String json = JsonUtil.getInstance().obj2json(args);
			logs.setOperParams(json);
			//调用目标对象的方法
			Object ret = pjp.proceed();
			logs.setOperResult("success");
			if(ret != null) {
				//将返回结果转换为json格式存入到数据库中
				String retJson = JsonUtil.getInstance().obj2json(ret);
				logs.setResultMsg(retJson);
			}
			return ret;
		} catch (Throwable e) {
			logs.setOperResult("failure");
			logs.setResultMsg(e.getMessage());
		} finally {
			logsService.add(logs);
		}
		return null;
	}
	
	
}
