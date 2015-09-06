package org.wcy.wee.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wcy.wee.common.exception.CustomException;
import org.wcy.wee.weixin.model.WeixinMenu;
import org.wcy.wee.weixin.service.WeixinMenuService;

@Controller
@RequestMapping(value="/weixinMenu")
public class WeixinMenuController {
	
	@Autowired
	private WeixinMenuService weixinMenuService;
	

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		List<WeixinMenu> menus = weixinMenuService.listAll();
		model.addAttribute("menus", menus);
		return "weixinMenu/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "weixinMenu/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(WeixinMenu weixinMenu) {
		weixinMenuService.add(weixinMenu);
		return "redirect:/weixinMenu/list";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id,Model model) {
		weixinMenuService.delete(id);
		return "redirect:/weixinMenu/list";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		WeixinMenu wm = weixinMenuService.load(id);
		model.addAttribute("wm", wm);
		return "weixinMenu/update";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(WeixinMenu wm) {
		weixinMenuService.update(wm);
		return "redirect:/weixinMenu/list";
	}
	
	/**
	 * 发布菜单
	 * @throws CustomException 
	 */
	@RequestMapping(value="/publishMenu", method=RequestMethod.GET)
	public String publishMenu() throws CustomException {
		weixinMenuService.publishMenu();
		return "redirect:/weixinMenu/list";
	}
}
