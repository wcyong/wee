package org.wcy.wee.demo.servlet3;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 * 异步调用对应的监听器 
 * @author wcyong
 *
 * date    2015年8月29日
 */
public class MyAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("异步调用完成");
		event.getSuppliedResponse().getWriter().println("异步调用完成");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("异步调用超时");
		event.getSuppliedResponse().getWriter().println("异步调用超时");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("异步调用出错");
		event.getSuppliedResponse().getWriter().println("异步调用出错");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("异步调用开始");
		event.getSuppliedResponse().getWriter().println("异步调用开始");
	}

}
