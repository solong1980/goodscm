package com.xlw.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class FastXmlDateSerializer extends DateSerializer {
	private static final long serialVersionUID = 1L;
	private static final String dateFormate = "yyyy-MM-dd HH:mm:ss";
	private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if (date == null)
			return;

		// parser as date
		SimpleDateFormat dateFormat = tl.get();
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat(dateFormate);
			tl.set(dateFormat);
		}
		String text = dateFormat.format(date);
		gen.writeString(text);
	}

}
