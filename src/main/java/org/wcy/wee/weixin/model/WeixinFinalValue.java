package org.wcy.wee.weixin.model;

public class WeixinFinalValue {

	//获取accessToken
	//测试帐号
	public static final String APPID = "wxcb3d856448587b61";
	public static final String APPSECRET = "bf0b7d7d4aae3679c10e858e0c5f5d78";
	
	//自己帐号
	/*public static final String APPID = "wx3d49de77c499c55c";
	public static final String APPSECRET = "e572748b9ca584c1a4be9e2042c1d1c4";*/
	
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	//添加菜单
	public static final String MENU_ADD = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	//消息类型
	public static final String MSG_TEXT_TYPE = "text";
	public static final String MSG_IMAGE_TYPE = "image";
	public static final String MSG_VOICE_TYPE = "voice";
	public static final String MSG_SHORTVIDEO_TYPE = "shortvideo";
	public static final String MSG_LOCATION_TYPE = "location";
	public static final String MSG_LINK_TYPE = "link";
	
	//消息群发
	public static final String MSG_SEND_ALL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	
	public final static String MSG_EVENT_TYPE = "event";
	
	//模板消息发送
	public static final String SEND_TEMPLATE_MSG = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	
	
	//用户组
	public static final String ADD_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	public static final String QUERY_ALL_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	public static final String QUERY_USER_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	public static final String UPDATE_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	public static final String MOVE_USER_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	public static final String MOVE_USERS_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
	public static final String DELETE_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN";

	//图片上传
	public final static String POST_MEDIA="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	public final static String GET_MEDIA="https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	
}
