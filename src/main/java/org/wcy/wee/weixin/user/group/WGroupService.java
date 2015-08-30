package org.wcy.wee.weixin.user.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.wcy.wee.common.util.JsonUtil;
import org.wcy.wee.weixin.model.WeixinFinalValue;
import org.wcy.wee.weixin.user.model.WGroup;
import org.wcy.wee.weixin.util.WeixinKit;

@Service
public class WGroupService implements IWGroupService {

	@Override
	public void add(WGroup wGroup) {
		String url = WeixinFinalValue.ADD_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, WGroup> map = new HashMap<String, WGroup>();
		map.put("group", wGroup);
		String json = JsonUtil.getInstance().obj2json(map);
		String result = WeixinKit.postReq(url, json, "application/json");
		System.out.println(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<WGroup> queryAll() {
		String url = WeixinFinalValue.QUERY_ALL_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		String json = WeixinKit.reqGet(url);
		Map<String, List> maps = (Map<String, List>) JsonUtil.getInstance().json2obj(json, Map.class);
		List<Map> listMap = maps.get("groups");
		List<WGroup> wgs = new ArrayList<WGroup>();
		for(Map m : listMap) {
			WGroup group = new WGroup();
			group.setId((Integer)m.get("id"));
			group.setName((String)m.get("name"));
			group.setCount((Integer)m.get("count"));
			wgs.add(group);
		}
		return wgs;
	}

	@Override
	public WGroup queryUserGroup(String openId) {
		List<WGroup> gs = queryAll();
		String url = WeixinFinalValue.QUERY_USER_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, String> map = new HashMap<String,String>();
		map.put("openid", openId);
		String json = JsonUtil.getInstance().obj2json(map);
		System.out.println(json);
		String str = WeixinKit.postReq(url, json, "application/json");
		@SuppressWarnings("unchecked")
		Map<String, Integer> gm = (Map<String, Integer>) JsonUtil.getInstance().json2obj(str, Map.class);
		Integer gid = gm.get("groupid");
		for(WGroup g : gs) {
			if(g.getId() == gid) {
				return g;
			}
		}
		return null;
	}

	@Override
	public void updateGroupName(int gid, String groupName) {
		String url = WeixinFinalValue.UPDATE_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", gid);
		map.put("name", groupName);
		Map<String, Map<String, Object>> gm = new HashMap<String, Map<String, Object>>();
		gm.put("group", map);
		String json = JsonUtil.getInstance().obj2json(gm);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}

	@Override
	public void moveUserToGroup(String openId, int gid) {
		String url = WeixinFinalValue.MOVE_USER_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openId);
		map.put("to_groupid", gid);
		String json = JsonUtil.getInstance().obj2json(map);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}

	@Override
	public void moveUsersToGroup(List<String> openIds, int gid) {
		String url = WeixinFinalValue.MOVE_USERS_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid_list", openIds);
		map.put("to_groupid", gid);
		String json = JsonUtil.getInstance().obj2json(map);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}

	@Override
	public void deleteGroup(int gid) {
		String url = WeixinFinalValue.DELETE_GROUP;
		url = WeixinKit.replaceAccessToken(url);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", gid);
		Map<String, Object> gm = new HashMap<String, Object>();
		gm.put("group", map);
		String json = JsonUtil.getInstance().obj2json(gm);
		System.out.println(json);
		String rs = WeixinKit.postReq(url, json, "application/json");
		System.out.println(rs);
	}

}
