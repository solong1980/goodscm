package com.xlw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	private static final String dateFormate = "yyyy-MM-dd hh:mm:ss";

	@Override
	public Date convert(String value) {
		if (StringUtils.isEmpty(value))
			return null;
		else {
			try {
				return new SimpleDateFormat(dateFormate).parse(value);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
