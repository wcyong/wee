package org.wcy.wee.weixin.user.group;

import java.util.List;

import org.wcy.wee.weixin.user.model.WGroup;

public interface IWGroupService {

	/**
	 * 创建分组
	 * @param wGroup
	 */
	public void add(WGroup wGroup);
	
	/**
	 * 查询所有分组
	 */
	public List<WGroup> queryAll();
	
	/**
	 * 查询用户所在分组
	 */
	public WGroup queryUserGroup(String openId);
	
	/**
	 * 修改分组名
	 */
	public void updateGroupName(int gid, String groupName);
	
	/**
	 * 移动用户分组
	 */
	public void moveUserToGroup(String openId, int gid);
	
	/**
	 * 批量移动用户分组
	 * @param openIds
	 * @param gid
	 */
	public void moveUsersToGroup(List<String> openIds, int gid);
	
	/**
	 * 删除分组
	 * @param gid
	 */
	public void deleteGroup(int gid);
	
}
 