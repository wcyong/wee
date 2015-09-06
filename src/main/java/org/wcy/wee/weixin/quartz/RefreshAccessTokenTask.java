package org.wcy.wee.weixin.quartz;

import org.springframework.stereotype.Component;
import org.wcy.wee.common.util.JsonUtil;
import org.wcy.wee.weixin.json.AccessToken;
import org.wcy.wee.weixin.kit.WeixinKit;
import org.wcy.wee.weixin.model.WeixinFinalValue;
import org.wcy.wee.weixin.servlet.WeixinContext;

@Component
public class RefreshAccessTokenTask {
	
	public void refreshToken() {
		String url = WeixinFinalValue.ACCESS_TOKEN_URL;
		url = url.replaceAll("APPID", WeixinContext.getInstance().getAppId());
		url = url.replaceAll("APPSECRET", WeixinContext.getInstance().getAppSecret());
		String content = WeixinKit.sendGet(url);
		if(WeixinKit.checkRequestSucc(content)) {
			AccessToken at = (AccessToken)JsonUtil.getInstance().json2obj(content, AccessToken.class);
			WeixinContext.getInstance().setAccessToken(at);
		} else {
			refreshToken();
		}
	}
}
