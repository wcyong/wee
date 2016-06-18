package org.wcy.wee;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;

public class MyShiroHttpServletResponse extends ShiroHttpServletResponse {

	public MyShiroHttpServletResponse(HttpServletResponse wrapped, ServletContext context,
			ShiroHttpServletRequest request) {
		super(wrapped, context, request);
	}

	@Override
	protected String toEncoded(String url, String sessionId) {
		if(StringUtils.isBlank(url) || StringUtils.isBlank(sessionId)) {
			return url;
		}
		String path = url;
	    String query = "";
	    String anchor = "";
	    int question = url.indexOf('?');
	    if (question >= 0) {
	      path = url.substring(0, question);
	      query = url.substring(question);
	    }
	    int pound = path.indexOf('#');
	    if (pound >= 0) {
	      anchor = path.substring(pound);
	      path = path.substring(0, pound);
	    }
	    StringBuilder sb = new StringBuilder(path);
	    sb.append(anchor);
	    sb.append(query);
	    return sb.toString();
	}
	
	

}
