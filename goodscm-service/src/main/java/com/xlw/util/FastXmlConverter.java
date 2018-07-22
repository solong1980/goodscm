package com.xlw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.util.StdConverter;

public class FastXmlConverter extends StdConverter<String, Date> {

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
