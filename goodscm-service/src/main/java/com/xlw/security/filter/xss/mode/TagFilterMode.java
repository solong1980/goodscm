package com.xlw.security.filter.xss.mode;

import com.xlw.security.filter.xss.pattern.PatternUtil;

public class TagFilterMode extends FilterMode {
	public String returnGegEx() {
		return "<script、<embed、<style、<frame、<object、<iframe、<frameset、<meta and so on. And operation with on*";
	}

	protected boolean isMatch(String value) {
		return this.pattern.matcher(value).find();
	}

	protected void setPattern() {
		this.pattern = PatternUtil.returnTagPattern();
	}
}
