package org.wcy.wee.weixin.quartz;

import org.springframework.stereotype.Component;
import org.wcy.wee.weixin.model.WeixinContext;

@Component
public class RefreshAccessTokenTask {
	
	public static final String ACCESS_TOKEN = "Jv-iHjp0S_O7k0d2QkMm81lus2hY5L1APPNEtRDrvFY2bBFBa9ND8ghhDiBprcfjVRbdzdvOXWj-8a2l3PXfzlVhl5qy9gtl_i5fn_bALuU";

	public void refreshToken() {
		WeixinContext.setAccessToken(RefreshAccessTokenTask.ACCESS_TOKEN);
		
		/*HttpGet get = null;
		CloseableHttpResponse resp = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			String url = WeixinFinalValue.ACCESS_TOKEN_URL;
			url = url.replaceAll("APPID", WeixinFinalValue.APPID);
			url = url.replaceAll("APPSECRET", WeixinFinalValue.APPSECRET);
			get = new HttpGet(url);
			resp = client.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 300) {
				HttpEntity entity = resp.getEntity();
				String content = EntityUtils.toString(entity);
				try {
					AccessToken at = (AccessToken) JsonUtil.getInstance().json2obj(content, AccessToken.class);
					WeixinContext.setAccessToken(at.getAccess_token());
				} catch (Exception e) {
					ErrorEntity err = (ErrorEntity) JsonUtil.getInstance().json2obj(content, ErrorEntity.class);
					System.out.println("获取token异常:" + err.getErrcode() + "," + err.getErrmsg());
					refreshToken();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resp != null)
					resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
}
