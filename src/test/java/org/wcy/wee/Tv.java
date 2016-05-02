package org.wcy.wee;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.wcy.wee.common.util.PropUtil;
import org.wcy.wee.demo.treegrid.GoodsCategory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Tv {
	
	@Test
	public void testGenTreeGridJson() {
		/*String value = PropUtil.getValue("jdbc.driver");
		System.out.println(value);*/
		/*String uuid = UUID.randomUUID().toString();
		uuid = "630874d8-d335-4ad1-ad2d-19780c723a3c";
		System.out.println(uuid);
		System.out.println(System.currentTimeMillis());
		System.out.println(uuid.hashCode()+System.currentTimeMillis());*/
	}
	
	
	/*private String createTreeJson(List<GoodsCategory> list) {
		JSONArray rootArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			GoodsCategory cc = list.get(i);
			// PARENT_ID=0 表示是根节点
			if (cc.getParentId() == 0) {
				JSONObject rootObj = createBranch(list, cc);
				rootArray.add(rootObj);
			}
		}
		return rootArray.toString();
	}

	private JSONObject createBranch(List<GoodsCategory> list, GoodsCategory currentNode) {
		JSONObject currentObj = JSONObject.fromObject(currentNode);
		JSONArray childArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			GoodsCategory newNode = list.get(i);
			if (newNode.getParentId() != null && newNode.getParentId().compareTo(currentNode.getCategoryId()) == 0) {
				JSONObject childObj = createBranch(list, newNode);
				childArray.add(childObj);
			}
		}
		if (!childArray.isEmpty()) {
			currentObj.put("children", childArray);
		}
	}*/
}
