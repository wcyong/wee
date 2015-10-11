package org.wcy.wee.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 * @author wcyong
 *
 * @date   2015年10月9日
 */
public class HttpSessionProvider implements SessionProvider{

	@Override
	public void setAttribute(HttpServletRequest request,HttpServletResponse response, String name,
			Serializable value) {
		HttpSession session = request.getSession();//true    Cookie JSESSIONID
		session.setAttribute(name, value);
	}

	@Override
	public Serializable getAttribute(HttpServletRequest request,HttpServletResponse response, String name) {
		HttpSession session = request.getSession(false);
		if(session != null){
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
		return request.getSession().getId();
	}

}