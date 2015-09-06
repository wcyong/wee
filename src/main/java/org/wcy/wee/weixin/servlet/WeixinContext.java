package org.wcy.wee.weixin.servlet;

import org.wcy.wee.weixin.json.AccessToken;

public class WeixinContext {

	private String appId;
	private String appSecret;
	private String token;
	private String baseUrl;
	private static WeixinContext wc;
	private AccessToken accessToken;
	
	private WeixinContext() {}
	
	public static WeixinContext getInstance() {
		if(wc == null) {
			wc = new WeixinContext();
		}
		return wc;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	
	
}
