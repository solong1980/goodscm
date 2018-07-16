package com.xlw.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FastXmlDateDeserializer extends JsonDeserializer<Date> {

	private static final String dateFormate = "yyyy-MM-dd HH:mm:ss";
	private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		String text = parser.getText();
		if (StringUtils.isEmpty(text))
			return null;
		if (text.contains(" ")) {
			// parser as date
			SimpleDateFormat dateFormat = tl.get();
			if (dateFormat == null) {
				dateFormat = new SimpleDateFormat(dateFormate);
				tl.set(dateFormat);
			}
			try {
				return dateFormat.parse(text);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		} else
			return context.parseDate(parser.getText());
	}
}
