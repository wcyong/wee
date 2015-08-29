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
 * 4.异步调用监听器
 * 
 * 当我们需要对异步调用做一个详细的监听的时候，比如监听它是否超时，我们可以通过给AsyncContext设置对应的监听器AsyncListener
 * 来实现这一功能。AsyncListener是一个接口，里面定义了四个方法，分别是针对于异步调用开始、结束、出错和超时的
 * 
 * 对于Servlet的异步返回，首先我们必须指定@WebServlet的asyncSupported属性为true（默认是false），同时在它之前的Filter
 * 的asyncSupported属性也必须是true，否则传递过来的request就是不支持异步调用的
 * 
 * 
 * 注：
 * 对于正常执行的异步调用而言上述代码中开始是没有监听到的，只有在异步调用超时，重新执行异步任务的时候才有监听到异步调用的开始。
 * 不过如果需要监听异步第一次开始的话，我们可以在异步调用开始的时候做相应的监听器监听到异步调用开始时需要做的内容
 * 
 * @author wcyong
 *
 * date    2015年8月29日
 */
@WebServlet(asyncSupported=true,urlPatterns="/servlet/async3")
public class AsyncServlet3 extends HttpServlet {

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
		out.println("3-异步之前输出的内容");
		out.flush();
		//开始异步调用，获取AsyncContext
		final AsyncContext asyncContext = req.startAsync();
		//设置当前异步调用对应的监听器
		asyncContext.addListener(new MyAsyncListener());
		//设置超时时间，当超时之后程序会尝试重新执行异步任务，即我们新起的线程
		asyncContext.setTimeout(10000);
		//新起线程开始异步调用，start方法不是阻塞式的，它会新起一个线程来启动Runnable接口，之后主程序会继续执行
		asyncContext.start(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					out.println("3异步调用之后输出的内容");
					out.flush();
					//异步调用完成
					asyncContext.complete();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		out.println("可能在异步调用前输出，也可能在异步调用之后输出，因为异步调用会新起一个线程。");
		out.flush();
	}

	
}
