package com.xlw.security.filter.xss.mode;

import com.xlw.security.filter.xss.pattern.PatternUtil;

public class SpecialCharacterFilterMode extends FilterMode {
	public String returnGegEx() {
		return "\\'、\\\"、+、/、%、&、<、>、(、)、;、{、}、!、@、~、#";
	}

	protected boolean isMatch(String value) {
		return this.pattern.matcher(value).find();
	}

	protected void setPattern() {
		this.pattern = PatternUtil.returnSpeCharPattern();
	}
}
