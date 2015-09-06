package org.wcy.wee.weixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcy.wee.common.exception.CustomException;
import org.wcy.wee.common.util.JsonUtil;
import org.wcy.wee.weixin.dto.WeixinMenuDto;
import org.wcy.wee.weixin.kit.WeixinKit;
import org.wcy.wee.weixin.mapper.WeixinMenuMapper;
import org.wcy.wee.weixin.model.WeixinFinalValue;
import org.wcy.wee.weixin.model.WeixinMenu;

@Service
public class WeixinMenuServiceImpl implements WeixinMenuService {
	
	@Autowired
	private WeixinMenuMapper weixinMenuMapper;
	
	@Override
	public WeixinMenu loadByKey(String key) {
		return weixinMenuMapper.loadByKey(key);
	}

	@Override
	public List<WeixinMenu> listAll() {
		return weixinMenuMapper.listAll();
	}

	@Override
	public void add(WeixinMenu menu) {
		if(menu.getType().equals("click"))
			menu.setMenuKey("KEY_"+System.currentTimeMillis());
		weixinMenuMapper.add(menu);
	}

	@Override
	public void delete(int id) {
		weixinMenuMapper.delete(id);
	}

	@Override
	public WeixinMenu load(int id) {
		return weixinMenuMapper.load(id);
	}

	@Override
	public void update(WeixinMenu wm) {
		weixinMenuMapper.update(wm);
	}

	@Override
	public void publishMenu() throws CustomException {
		String url = WeixinKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_ADD);
		System.out.println(url);
		List<WeixinMenuDto> wmds = generateWeixinMenuDto();
		Map<String,List<WeixinMenuDto>> maps = new HashMap<String,List<WeixinMenuDto>>();
		maps.put("button", wmds);
		String json =  JsonUtil.getInstance().obj2json(maps);
		System.out.println(json);
		String rel = WeixinKit.sendJsonPost(url,json);
		if(!WeixinKit.checkRequestSucc(rel)) {
			throw new RuntimeException("发布菜单失败："+WeixinKit.getRequestMsg(rel));
		}
	}
	
	public List<WeixinMenuDto> generateWeixinMenuDto() {
		List<WeixinMenu> menus = this.listAll();
		List<WeixinMenuDto> menuDtos = new ArrayList<WeixinMenuDto>();
		WeixinMenuDto wmd = null;
		for(WeixinMenu wm:menus) {
			wmd = new WeixinMenuDto();
			wmd.setKey(wm.getMenuKey());
			wmd.setName(wm.getName());
			wmd.setType(wm.getType());
			wmd.setId(wm.getId());
			wmd.setUrl(wm.getUrl());
			if(wm.getPid()==null||wm.getPid()==0) {
				if(wmd.getSub_button()==null) {
					wmd.setSub_button(new ArrayList<WeixinMenuDto>());
				}
				menuDtos.add(wmd);
			} else {
				WeixinMenuDto twmd = findById(wm.getPid(), menuDtos);
				if(twmd==null) throw new RuntimeException("菜单的父类对象有问题，请检查");
				twmd.getSub_button().add(wmd);
			}
		}
		return menuDtos;
	}

	private WeixinMenuDto findById(int id,List<WeixinMenuDto> wmds) {
		for(WeixinMenuDto wmd:wmds) {
			if(wmd.getId()==id) {
				return wmd;
			}
		}
		return null;
	}
	
	
	

}
