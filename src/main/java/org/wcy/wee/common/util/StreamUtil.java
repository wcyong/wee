package org.wcy.wee.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {

	/**
	 * 将一个流里面的内容转换成为一个字符串
	 * @param is  流里面的内容
	 * @return
	 */
	public static String readStream(InputStream is) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			if((len=is.read(buf)) !=1) {
				baos.write(buf, 0, len);
			}
			return new String(buf);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
