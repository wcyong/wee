package org.wcy.wee.sys.model;

/**
 * 组织规则表
 * 用来确定组织之间的管理关系
 * @author wcyong
 *
 * @date   2015年9月12日
 */
public class OrgRule {
	
	//默认管理类型，表示直线型的管理，某个组织职能管理它下面的所有子组织
	public static final int DEFAULT_TYPE = 0;
	//可以管理所有的组织机构中的信息
	public static final int ALL_TYPE = 1;
	//自定义的管理类型，如果是该管理类型，需要到managerOrg这个字段中获取可以管理的所有的组织
	public static final int DEF_TYPE = 2;
	//如果组织的管理类型属于-1，表示不具备管理功能
	public static final int NO_TYPE = -1;

	/**
	 * 唯一编号
	 */
	private String id;
	/**
	 * 组织机构id
	 */
	private String orgId;
	/**
	 * 具体的管理组织,当管理类型为DEF_TYPE时，就从该字段中找到所有的可以管理的组织
	 * (2)(3)(2)
	 * 这里存储的是管理组织的根组织
	 */
	private String managerOrg;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getManagerOrg() {
		return managerOrg;
	}
	public void setManagerOrg(String managerOrg) {
		this.managerOrg = managerOrg;
	}
	
}
