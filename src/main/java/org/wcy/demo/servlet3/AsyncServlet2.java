package org.wcy.demo.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 3.异步调用
 * 
 * 在Servlet3.0中，在Servlet内部支持异步处理。它的逻辑是当我们请求一个Servlet时，我们的Servlet可以先返回一部分内容给客户端。
 * 然后在Servlet内部异步处理另外一段逻辑，等到异步处理完成之后，再把异步处理的结果返回给客户端。这意味着当我们的Servlet在处理
 * 一段比较费时的业务逻辑时，我们可以先返回一部分信息给客户端，然后异步处理费时的业务，而不必让客户端一直等待所有的业务逻辑处理完。
 * 等到异步处理完之后，再把对应的处理结果返回给客户端。异步调用是通过当前HttpServletRequest的startAsync()方法开始的，
 * 它返回一个AsyncContext。之后我们可以调用AsyncContext的start()方法来新起一个线程进行异步调用。在新线程内部程序的
 * 最后我们最好是调用一下当前AsyncContext的complete()方法，否则异步调用的结果需要等到设置的超时时间过后才会返回到客户端。
 * 另外当异步调用超时以后会接着调用异步任务，即新起的线程。
 * 
 * 
 * 支持异步返回的Servlet
 * 对于Servlet的异步返回，首先我们必须指定@WebServlet的asyncSupported属性为true（默认是false），同时在它之前的Filter
 * 的asyncSupported属性也必须是true，否则传递过来的request就是不支持异步调用的。
 * 而对于在web.xml文件中进行配置的Servlet来说，我们需要在配置的时候指定其asyncSupported属性为true。
 *    <servlet>
 *    	<servlet-name>xxx</servlet-name>
 *    	<servlet-class>xxx</servlet-class>
 *    	<async-supported>true</async-supported>
 *    </servlet>
 *    <servlet-mapping>
 *    	<servlet-name>xxx</servlet-name>
 *    	<url-pattern>xxx</url-pattern>
 *    </servlet-mapping>
 * 
 * 如果在web.xml中使用了filter过滤器，则需要在filter中增加<async-supported>为true
 * <filter> 
 * 	<filter-name>xxxFilter</filter-name> 
 * 	<filter-class>xxxxFilter</filter-class> 
 * 	<async-supported>true</async-supported>
 * </filter> 
 * 
 * Servlet的异步调用程序的关键是要调用当前HttpServletRequest的startAsync()方法。至于利用返回的AsyncContext
 * 来新起一个线程进行异步处理就不是那么的必须了，因为在HttpServletRequest startAsync()之后，
 * 我们可以自己新起线程进行异步处理
 * 
 * 
 * @author wcyong
 *
 * date    2015年8月29日
 */
@WebServlet(asyncSupported=true,urlPatterns="/servlet/async2")
public class AsyncServlet2 extends HttpServlet {

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
		resp.setContentType("text/plain;charset=utf-8");
		final PrintWriter out = resp.getWriter();
		out.println("2异步之前输出的内容");
		out.flush();
		//开始异步调用，获取对应的AsyncContext。  
		final AsyncContext asyncContext = req.startAsync();
		//设置超时时间，当超时之后程序会尝试重新执行异步任务，即我们新起的线程
		asyncContext.setTimeout(60000);
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(40000);
					out.println("2异步调用之后输出的内容");
					out.flush();
					//异步调用完成
					asyncContext.complete();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//开启自己的线程进行异步处理 
		Thread t = new Thread(r);
		t.start();
		
		out.println("2可能在异步调用前输出，也可能在异步调用之后输出，因为异步调用会新起一个线程");
		out.flush();
	}

	
}
