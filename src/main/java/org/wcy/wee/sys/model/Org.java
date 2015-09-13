package org.wcy.wee.sys.model;
/**
 * 组织机构对象，该表可以生成完整的组织树
 * 根据组织类型来具体存储实际中存在的组织
 * @author wcyong
 *
 * @date   2015年9月12日
 */
public class Org {

	/**
	 * 组织机构的id
	 */
	private String id;
	/**
	 * 组织机构名称
	 */
	private String name;
	/**
	 * 组织机构所属类型的id
	 */
	private String typeId;
	/**
	 * 组织机构所属类型的名称，冗余
	 */
	private String typeName;
	/**
	 * 组织机构的排序号
	 */
	private int orderNum;
	/**
	 * 组织机构的父组织
	 */
	private String pid;
	/**
	 * 管理类型
	 */
	private int managerype;
	/**
	 * 组织机构的地址
	 */
	private String address;
	/**
	 * 组织机构联系电话
	 */
	private String phone;
	/**
	 * 扩展属性1，用于在针对某些特殊的组织存储相应的信息
	 */
	private String att1;
	/**
	 * 扩展属性2，用于在针对某些特殊的组织存储相应的信息
	 */
	private String att2;
	/**
	 * 扩展属性3，用于在针对某些特殊的组织存储相应的信息
	 */
	private String att3;
	
	
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
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getManagerype() {
		return managerype;
	}
	public void setManagerype(int managerype) {
		this.managerype = managerype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAtt1() {
		return att1;
	}
	public void setAtt1(String att1) {
		this.att1 = att1;
	}
	public String getAtt2() {
		return att2;
	}
	public void setAtt2(String att2) {
		this.att2 = att2;
	}
	public String getAtt3() {
		return att3;
	}
	public void setAtt3(String att3) {
		this.att3 = att3;
	}
	
}
