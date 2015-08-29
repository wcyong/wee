package org.wcy.weixin.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wcy.weixin.model.WeixinContext;
import org.wcy.weixin.msg.MessageKit;
import org.wcy.weixin.util.SecurityKit;

/**
 * 微信接入
 * 1.填写服务器配置
 * 2.验证服务器地址的有效性
 * 3.依据接口文档实现业务逻辑
 * 
 * @author wcyong
 *
 * date    2015年8月21日
 */
@Controller
@RequestMapping(value="/weixin")
public class WeixinController {

	public static final String TOOKEN  = "wcyong";

	/**
	 * 验证服务器地址的有效性
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping(value="/wget", method=RequestMethod.GET)
	public void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature");
		//时间戳
		String timestamp = request.getParameter("timestamp");
		//随机数
		String nonce = request.getParameter("nonce");
		//随机字符串
		String echostr = request.getParameter("echostr");
		
		String[] arrs = {WeixinController.TOOKEN, nonce, timestamp};
		//1. 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arrs);
		
		//2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer sb = new StringBuffer();
		for(String s : arrs) {
			sb.append(s);
		}
		String sha1 = SecurityKit.sha1(sb.toString());
		//3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if(sha1.equals(signature)) {
			response.getWriter().println(echostr);
		}
		
	}
	
	@RequestMapping(value="/wget", method=RequestMethod.POST)
	public void getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
		String line = null;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}*/
		
		Map<String, String> maps = MessageKit.reqMsg2Map(request);
		
		String respCon = MessageKit.handlerMsg(maps);
		System.out.println(respCon);
		response.setContentType("application/xml;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respCon);
	}
	
	@RequestMapping(value="/at", method = RequestMethod.GET)
	public void genAccessToken(HttpServletResponse resp) throws IOException {
		resp.getWriter().println(WeixinContext.getAccessToken());
	}
	
}
