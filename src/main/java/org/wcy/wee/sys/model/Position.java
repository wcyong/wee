package org.wcy.wee.sys.model;

/**
 * 岗位对象，用来确定某个人员所属的岗位
 * @author wcyong
 *
 * @date   2015年9月12日
 */
public class Position {

	/**
	 * 唯一标识
	 */
	private String id;
	/**
	 * 岗位名称
	 */
	private String name;
	/**
	 * 岗位的sn
	 */
	private String sn;
	/**
	 * 岗位是否具备管理功能
	 */
	private int manager;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	
}
