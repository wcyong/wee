package org.wcy.wee.weixin.model;

public class WeixinContext {
	private static String accessToken;
	
	public static void setAccessToken(String accessToken) {
		WeixinContext.accessToken = accessToken;
	}
	
	public static String getAccessToken() {
		return WeixinContext.accessToken;
	}
}
