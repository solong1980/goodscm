package com.xlw.security.filter.xss.pattern;

import java.util.regex.Pattern;

public class PatternUtil {
	public static Pattern returnTagPattern() {
		return Pattern.compile(

				"(<\\s*script\\s*)|(<\\s*embed\\s*)|(<\\s*style\\s*)|(<\\s*frame\\s*)|(<\\s*object\\s*)|(<\\s*iframe\\s*)"
						+ "|(<\\s*frameset\\s*)|(<\\s*meta\\s*)|(<\\s*xml\\s*)|(<\\s*applet\\s*)|(<\\s*link\\s*)|(<\\s*blink\\s*)"
						+ "|(<\\s*img\\s*)|(<\\s*xss\\s*)|(<\\s*html\\s*)|(<\\s*base\\s*)|(<\\s*body\\s*)|(<\\s*bgsound\\s*)" +

						"|(\\s*on.*\\s*=)" +

						"|(\\s*javascript\\s*)|(\\s*vbscript\\s*)|(\\s*expression\\s*)" + "|(\\s*alert\\s*\\()",

				2);
	}

	public static Pattern returnSpeCharPattern() {
		return Pattern.compile("['\"+/%&<>();{}!@~#]");
	}

	public static Pattern makeUrlExcludePattern(String _urlExclude) {
		String urlExclude = _urlExclude.replaceAll("\\*", ".*");
		StringBuffer ap = new StringBuffer("(.*)(");
		String[] exs = urlExclude.split(",");
		for (int i = 0; i < exs.length; i++) {
			String s = exs[i];
			ap.append("(").append(s).append(")|");
		}
		ap.deleteCharAt(ap.length() - 1);
		ap.append(")");
		return Pattern.compile(ap.toString());
	}
}
