package com.xlw.security.filter.xss.mode;

public class NoneFilterMode extends FilterMode {
	public String returnGegEx() {
		return null;
	}

	protected boolean isMatch(String value) {
		return true;
	}

	protected void setPattern() {
		this.pattern = null;
	}
}
