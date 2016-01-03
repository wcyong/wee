package org.wcy.wee.common.util;

import java.util.ResourceBundle;

/**
 * 读取properties文件
 * @author wcyong
 *
 * @date   2015年12月31日
 */
public class PropUtil {

	private static ResourceBundle resourceBundle = null;
	static {
		try {
			resourceBundle = ResourceBundle.getBundle("db");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return resourceBundle.getString(key);
	}
}
