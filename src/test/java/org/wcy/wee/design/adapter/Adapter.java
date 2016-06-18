package org.wcy.wee.design.adapter;
/**
 * 适配器
 * @author wcyong
 *
 */
public class Adapter implements Target {
	
	private Adptee adptee;
	
	public Adapter(Adptee adptee) {
		this.adptee = adptee;
	}

	@Override
	public void handlerReq() {
		adptee.request();
	}
	
}
