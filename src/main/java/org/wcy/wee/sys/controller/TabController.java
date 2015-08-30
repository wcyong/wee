package org.wcy.wee.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/tab")
public class TabController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "tab/index";
	}
	
	@RequestMapping(value="/top", method=RequestMethod.GET)
	public String top() {
		return "tab/mainFrame";
	}
	
	@RequestMapping(value="/homeIndex", method=RequestMethod.GET)
	public String homeIndex() {
		return "tab/homeIndex";
	}
	
	@RequestMapping(value="/menu_list", method=RequestMethod.GET)
	public String menu_List() {
		return "tab/menu_list";
	}

}
