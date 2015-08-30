package org.wcy.wee.demo.servlet3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 1.注解配置
 * 
 * 
 * Servlet3.0新特性之Servlet注解 
 * 1.修改web.xml,将version改为3.0,将schema改为web-app_3_0.xsd
 * 2.在Servlet里面使用注解 
 * 
 * 
 * Servlet3.0支持使用注解配置Servlet。我们只需在Servlet对应的类上使用@WebServlet进行标注， 
 * 我们就可以访问到该Servlet了，而不需要再在web.xml文件中进行配置。@WebServlet的urlPatterns
 * 和value属性都可以用来表示Servlet的部署路径，它们都是对应的一个数组。
 * 
 * 对于一个@WebServlet而言，有一个属性是必须要的，那就是它的访问路径。@WebServlet中有两个属性可以
 * 用来表示Servlet的访问路径，分别是value和urlPatterns。value和urlPatterns都是数组形式，
 * 表示我们可以把一个Servlet映射到多个访问路径，但是value和urlPatterns不能同时使用。
 * 如果同时使用了value和urlPatterns，我们的Servlet是无法访问到的。
 * 
 * urlPatterns--指定Servlet的访问URL(可以指定多个访问路径,因为urlPatterns的值类型是数组)
 * initParams---设定初始参数,其值为WebInitParam类型的数组,所以它支持设定多个初始参数  
 *  另外,@WebInitParam注解通常不单独使用,而是同@WebServlet或者@WebFilter组合使用   
 *  而且,经过测试,单独使用@WebInitParam设定初始参数,设定失败   
 *  
 *
 *  
 *  
 * @author wcyong
 *
 * date    2015年8月29日
 */
@WebServlet(name="exampleServlet", urlPatterns="/servlet/example")
public class ExampleServlet extends HttpServlet{

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
		resp.getWriter().write("Hello User.");  
	}

	
}
