package org.wcy.wee.weixin.model;

/**
 * 微信菜单对象
 * @author wcyong
 *
 * date    2015年9月2日
 */
public class WeixinMenu {

	private int id;
	/**
	 * 菜单名称
	 */
	private String name;
	private String content;
	private String url;
	private String menuKey;
	private Integer pid;
	private String type;
	/**
	 * 响应类型,如果为1表示用content来响应
	 */
	private String respType;
	
	
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRespType() {
		return respType;
	}
	public void setRespType(String respType) {
		this.respType = respType;
	}
	
	
}
