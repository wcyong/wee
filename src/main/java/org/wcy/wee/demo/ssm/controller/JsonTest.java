package org.wcy.wee.demo.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wcy.wee.demo.ssm.model.User;

@Controller
@RequestMapping("/json")
public class JsonTest {

	//请求json串(用户信息)，输出json(用户信息)
	//@RequestBody将请求的用户信息的json串转成user对象
	//@ResponseBody将user转成json输出
	@RequestMapping(value="/requestJson", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public User requestJson(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getId());
		//@ResponseBody将user转成json输出
		return user;
	}
	
	@RequestMapping(value="/responseJson", method=RequestMethod.POST)
	@ResponseBody
	public User responseJson(User user) {
		System.out.println("=======================================================");
		System.out.println(user.getUsername());
		System.out.println(user.getId());
		return user;
	}
}
