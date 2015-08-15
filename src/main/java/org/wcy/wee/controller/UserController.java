package org.wcy.wee.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.wcy.wee.exception.CustomException;
import org.wcy.wee.model.User;
import org.wcy.wee.service.UserService;
import org.wcy.wee.validation.ValidGroup1;
import org.wcy.wee.validation.ValidGroup2;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 用户类型
	 * userType表示最终将方法返回值放到request中的key
	 * @return
	 */
	@ModelAttribute("userType")
	public Map<Integer, String> getUserType() {
		Map<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "普通用户");
		map.put(2, "初级用户");
		map.put(3, "高级用户");
		return map;
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<User> list = userService.findUserList();
		model.addAttribute("users", list);
		return "user/list";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) throws Exception {
		User user = userService.findByUserId(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String udpate(@PathVariable int id,@Validated(value={ValidGroup1.class,ValidGroup2.class}) User user,BindingResult br,MultipartFile user_pic,Model model,HttpServletRequest request) throws Exception {
		//获取错误信息
		if(br.hasErrors()) {
			//输出错误信息
			List<ObjectError> allErrors = br.getAllErrors();
			for(ObjectError oe : allErrors) {
				System.out.println(oe.getDefaultMessage());
			}
			//将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			return "user/edit";
		}
		
		User u = userService.findByUserId(id);
		if(u == null) {
			throw new CustomException("用户不存在");
		}
		
		//图片上传
		//原始名称
		String originalFilename = user_pic.getOriginalFilename();
		if(user_pic != null && originalFilename != null && originalFilename.length() > 0) {
			//存储图片的物理路径
			String pic_path = request.getSession().getServletContext().getRealPath("/resources/pic/");
			System.out.println(pic_path);
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+"/"+newFileName);
			
			//将内存中的数据写入磁盘
			user_pic.transferTo(newFile);
			
			//将新图片名称写到user中
			u.setPic(newFileName);
		}
		
		u.setUsername(user.getUsername());
		u.setSex(user.getSex());
		u.setBirthday(user.getBirthday());
		u.setAddress(user.getAddress());
		userService.updateUserById(id, u);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/deleteBatch", method=RequestMethod.POST)
	public String deleteBatch(Integer[] ids) {
		System.out.println(ids);
		for(Integer id : ids) {
			System.out.println(id);
		}
		return "redirect:/user/users";
	}
	
}
