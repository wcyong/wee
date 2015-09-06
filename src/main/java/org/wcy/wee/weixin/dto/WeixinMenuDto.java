package org.wcy.wee.weixin.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单dto对象
 * @author wcyong
 *
 * @date   2015年9月5日
 */
public class WeixinMenuDto {

	private String name;
	private String key;
	private String type;
	private String url;
	private List<WeixinMenuDto> sub_button = new ArrayList<WeixinMenuDto>();
	private int id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
	public List<WeixinMenuDto> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WeixinMenuDto> sub_button) {
		this.sub_button = sub_button;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
