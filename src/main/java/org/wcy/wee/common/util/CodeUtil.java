package org.wcy.wee.common.util;

import java.util.UUID;

/**
 * 编码，序列等生成工具
 * @author wcyong
 *
 * @date   2015年9月6日
 */
public class CodeUtil {

	/**
	 * 生成uuid
	 * @return
	 */
	public static String uuid() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
}
