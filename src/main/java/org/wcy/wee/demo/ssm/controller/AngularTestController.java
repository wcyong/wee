package org.wcy.wee.demo.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wcy.wee.demo.ssm.model.User;
import org.wcy.wee.demo.ssm.service.UserService;

@Controller
@RequestMapping(value="/angular")
public class AngularTestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/testDatas")
	@ResponseBody
	public List<User> testDatas(Model model) throws Exception {
		List<User> list = userService.findUserList();
		return list;
	}
	
}
