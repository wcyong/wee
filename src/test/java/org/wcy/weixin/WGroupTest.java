package org.wcy.weixin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wcy.weixin.user.group.IWGroupService;
import org.wcy.weixin.user.model.WGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class WGroupTest {
	
	@Autowired
	private IWGroupService wGroupService;
	
	@Test
	public void testAddWGroup() {
		WGroup group = new WGroup();
		group.setId(101);
		group.setName("测试组2");
		wGroupService.add(group);
	}
	
	@Test
	public void testQueryAll() {
		List<WGroup> list = wGroupService.queryAll();
		System.out.println(list);
	}
	
	@Test
	public void testQueryUserGroup() {
		WGroup group = wGroupService.queryUserGroup("o_CQ1wzWsq4Jp_WLz7nL1qUVHJXk");
		System.out.println(group);
	}
	
	/**
	 * [WGroup [id=0, name=未分组, count=1], WGroup [id=1, name=黑名单, count=0], WGroup [id=2, name=星标组, count=0], WGroup [id=100, name=测试组1, count=0], WGroup [id=101, name=测试组2, count=0]]
	 */
	@Test
	public void testUpdateGroupName() {
		wGroupService.updateGroupName(101, "修改测试");
	}
	
	@Test
	public void testMoveUserToGroup() {
		wGroupService.moveUserToGroup("o_CQ1wzWsq4Jp_WLz7nL1qUVHJXk", 2);
	}
	
	@Test
	public void testMoveUsersToGroup() {
		List<String> openIds = new ArrayList<String>();
		openIds.add("o_CQ1wzWsq4Jp_WLz7nL1qUVHJXk");
		wGroupService.moveUsersToGroup(openIds, 0);
	}
	
	@Test
	public void testDeleteGroup() {
		wGroupService.deleteGroup(101);
	}

}
