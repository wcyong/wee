package org.wcy.demo.servlet3;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2.初始化参数
 * 
 * 使用@WebServlet时也可以配置初始化参数，它是通过@WebServlet的initParams参数来指定的。
 * initParams是一个@WebInitParam数组，每一个@WebInitParam代表一个初始化参数。
 * 
 * @author wcyong
 *
 * date    2015年8月29日
 */
@WebServlet(value="/servlet/init-param", initParams={@WebInitParam(name="param1",value="value1")})
public class WebInitParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> paramNames = this.getServletConfig().getInitParameterNames();
		String paramName;
		while(paramNames.hasMoreElements()) {
			paramName = paramNames.nextElement();
			resp.getWriter().append(paramName+"="+this.getServletConfig().getInitParameter(paramName));
		}
		resp.getWriter().close();
	}

}
