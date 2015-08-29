package org.wcy.weixin.model;

import java.util.List;

/**
 * 微信菜单
 * @author wcyong
 *
 * date    2015年8月21日
 */
public class WeixinMenu {

	/**
	 * 菜单id
	 */
	private int id;
	/**
	 * 菜单标题
	 */
	private String name;
	/**
	 * 菜单的响应动作类型
	 */
	private String type;
	/**
	 * 网页链接，用户点击菜单可打开链接
	 */
	private String url;
	/**
	 * 菜单KEY值，用于消息接口推送
	 */
	private String key;
	private int pid;
	/**
	 * 二级菜单数组，个数应为1~5个
	 */
	private List<WeixinMenu> sub_button;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<WeixinMenu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WeixinMenu> sub_button) {
		this.sub_button = sub_button;
	}
	
	
}
