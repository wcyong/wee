package org.wcy.wee.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session操作接口
 * 	本地session,memcached,redis等均可以实现该接口
 * 
 * @author wcyong
 *
 * @date   2015年10月9日
 */
public interface SessionProvider {

	/**
	 * 向Session设置值
	 * @param name
	 * @param value
	 */
	public void setAttribute(HttpServletRequest request,HttpServletResponse response, String name,Serializable value);
	
	/**
	 * 从session中取值
	 * @param name
	 * @return
	 */
	public Serializable getAttribute(HttpServletRequest request,HttpServletResponse response,String name);
	
	/**
	 * 获取SessionID
	 * @return
	 */
	public String getSessionId(HttpServletRequest request,HttpServletResponse response);
	
}
