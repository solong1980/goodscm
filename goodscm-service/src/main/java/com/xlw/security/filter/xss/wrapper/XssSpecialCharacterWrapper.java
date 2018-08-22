package com.xlw.security.filter.xss.wrapper;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.xlw.security.filter.xss.pattern.PatternUtil;

public class XssSpecialCharacterWrapper extends FilterWrapper implements Serializable {
	private static final long serialVersionUID = -2905671395704895436L;
	private static final Pattern pattern = PatternUtil.returnSpeCharPattern();

	public XssSpecialCharacterWrapper(HttpServletRequest request) {
		super(request);
	}

	protected Pattern getPattern() {
		return pattern;
	}

	@SuppressWarnings("unused")
	private static String xssEncode(String s) {
		if ((s == null) || ("".equals(s))) {
			return s;
		}
		StringBuffer sb = new StringBuffer(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {

			case '>':
				sb.append(65310);
				break;
			case '<':
				sb.append(65308);
				break;
			case '\'':
				sb.append('‘');
				break;
			case '"':
				sb.append('“');
				break;
			case '&':
				sb.append(65286);
				break;
			case '\\':
				sb.append(65340);
				break;
			case '#':
				sb.append(65283);
				break;
			case '(':
				sb.append(65288);
				break;
			case ')':
				sb.append(65289);
				break;
			case ';':
				sb.append(65307);
				break;
			case '{':
				sb.append('【');
				break;
			case '}':
				sb.append('】');
				break;
			case '!':
				sb.append(65281);
				break;
			case '@':
				sb.append(65281);
				break;
			case '~':
				sb.append(65281);
				break;
			default:
				sb.append(c);
			}

		}
		return sb.toString();
	}
}
