package org.wcy.wee.sys.model;

/**
 * 组织机构类型的规则表，用来确定组织之间的关系
 * @author wcyong
 *
 * @date   2015年9月12日
 */
public class OrgTypeRule {
	/**
	 * 规则唯一标识
	 */
	private String id;
	/**
	 * 规则的父id
	 */
	private String pid;
	/**
	 * 规则的子id
	 */
	private String cid;
	/**
	 * 父规则下允许添加的子规则数量，如果为-1表示无限制
	 */
	private int num;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
