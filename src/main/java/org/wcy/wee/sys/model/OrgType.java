package org.wcy.wee.sys.model;

/**
 * 组织机构类型对象，用来设定系统中存在哪些组织机构类型
 * @author wcyong
 *
 * @date   2015年9月12日
 */
public class OrgType {

	/**
	 * 类型唯一标识
	 */
	private String id;
	/**
	 * 类型名称
	 */
	private String name;
	/**
	 * 类型的sn序号
	 */
	private String sn;
	
	
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
	
}
