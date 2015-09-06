package org.wcy.wee.weixin.service;

import java.util.List;

import org.wcy.wee.common.exception.CustomException;
import org.wcy.wee.weixin.model.WeixinMenu;

public interface WeixinMenuService {

	/**
	 * 通过key获取菜单
	 * @param key
	 * @return
	 */
	public WeixinMenu loadByKey(String key);
	
	/**
	 * 查询所有菜单
	 * @return
	 */
	public List<WeixinMenu> listAll();
	
	/**
	 * 添加菜单
	 * @param menu
	 */
	public void add(WeixinMenu menu);
	
	/**
	 * 删除菜单
	 * @param id
	 */
	public void delete(int id);
	
	public WeixinMenu load(int id);
	
	public void update(WeixinMenu wm);
	
	/**
	 * 发布菜单
	 * @throws CustomException 
	 */
	public void publishMenu() throws CustomException;
	
	
}
