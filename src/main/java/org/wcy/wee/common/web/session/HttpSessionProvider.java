package org.wcy.wee.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 */
public class HttpSessionProvider implements SessionProvider{

	private int expiry = 30;//分钟
	
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

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		//清理Cookie
		//Cookie JSESSIONID 		
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	
}
