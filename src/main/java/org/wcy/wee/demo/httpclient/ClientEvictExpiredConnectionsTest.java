package org.wcy.wee.demo.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * 关闭连接池中无效连接
 * @author wcyong
 *
 * @date   2016年3月12日
 */
public class ClientEvictExpiredConnectionsTest {

	public static void main(String[] args) {
		PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
		// 设置最大连接数
		pool.setMaxTotal(200);
		// 设置每个主机地址的并发数
		pool.setDefaultMaxPerRoute(20);

		new IdleConnectionEvictor(pool).start();
	}

	public static class IdleConnectionEvictor extends Thread {

		private final HttpClientConnectionManager mgr;

		private volatile boolean shutdown;

		public IdleConnectionEvictor(HttpClientConnectionManager mgr) {
			this.mgr = mgr;
		}

		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// 关闭失效的连接
						mgr.closeExpiredConnections();
					}
				}
			} catch (InterruptedException ex) {
				// 结束
			}
		}

		public void shutdown() {
			shutdown = true;
			synchronized (this) {
				notifyAll();
			}
		}

	}
}
