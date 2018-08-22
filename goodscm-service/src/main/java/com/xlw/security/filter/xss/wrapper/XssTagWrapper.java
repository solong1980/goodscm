package com.xlw.security.filter.xss.wrapper;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.xlw.security.filter.xss.pattern.PatternUtil;

public class XssTagWrapper extends FilterWrapper implements Serializable {
	private static final long serialVersionUID = -1549310937275036731L;
	private static final Pattern pattern = PatternUtil.returnTagPattern();

	public XssTagWrapper(HttpServletRequest request) {
		super(request);
	}

	protected Pattern getPattern() {
		return pattern;
	}
}
