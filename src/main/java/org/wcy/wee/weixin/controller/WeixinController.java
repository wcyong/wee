package org.wcy.wee.weixin.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wcy.wee.weixin.kit.SecurityKit;
import org.wcy.wee.weixin.servlet.WeixinContext;

/**
 * 微信接入 
 * 1.填写服务器配置
 * 2.验证服务器地址的有效性 
 * 3.依据接口文档实现业务逻辑
 * 
 * @author wcyong
 *
 * @date   2015年9月2日
 */
@Controller
@RequestMapping(value = "/weixin")
public class WeixinController {

	/**
	 * 验证服务器地址的有效性
	 * @throws IOException 
	 */
	@RequestMapping(value = "/wreceive", method = RequestMethod.GET)
	public void handlerGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		String[] arrs = {WeixinContext.getInstance().getToken(), nonce, timestamp };
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arrs);

		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer sb = new StringBuffer();
		for (String s : arrs) {
			sb.append(s);
		}
		String sha1 = SecurityKit.sha1(sb.toString());
		// 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if (sha1.equals(signature)) {
			response.getWriter().println(echostr);
		}
	}

}
