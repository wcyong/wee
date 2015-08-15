package org.wcy.wee.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 日期转换器
 * 
 * @author wcyong
 * 
 * date 2015年6月14日
 */
public class CustomDateConverter implements Converter<String, Date> {
	// 实现将日期格式字符串转成日期类型
	private SimpleDateFormat datetime_HHmmss_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat datetime_HHmm_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private SimpleDateFormat datetime_HH_Format = new SimpleDateFormat("yyyy-MM-dd HH");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date convert(String source) throws IllegalArgumentException {
		try {
			if (StringUtils.hasText(source)) {
				if (source.indexOf(":") == -1 && source.length() == 10) {
					return dateFormat.parse(source);
				} else if (source.indexOf(":") == -1 && source.length() == 13) {
					return datetime_HH_Format.parse(source);
				} else if (source.indexOf(":") > 0 && source.length() == 16) {
					return datetime_HHmm_Format.parse(source);
				} else if (source.indexOf(":") > 0 && source.length() == 19) {
					return datetime_HHmmss_Format.parse(source);
				} else {
					throw new IllegalArgumentException(
							"Could not parse date, date format is error ");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + e.getMessage());
			iae.initCause(e);
			throw iae;
		}
		return null;
	}

}
