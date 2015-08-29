package org.wcy.weixin.json;

public class AccessToken {

	/**
	 * access_token值
	 */
	private String access_token;
	/**
	 * access_token失效时间,默认为7200s
	 */
	private String expires_in;
	
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	
	
}
