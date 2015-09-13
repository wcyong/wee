package org.wcy.wee.sys.model;

/**
 * 人员组织岗位对应关系表，这张表里面存储了人员和组织和岗位的对应关系
 * @author wcyong
 *
 * @date   2015年9月12日
 */
public class PersonOrgPos {

	/**
	 * 唯一标识
	 */
	private String id;
	/**
	 * 人员id
	 */
	private String personId;
	/**
	 * 组织id
	 */
	private String orgId;
	/**
	 * 岗位id
	 */
	private String posId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}
	
}
