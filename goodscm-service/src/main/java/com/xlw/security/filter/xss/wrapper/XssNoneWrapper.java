package com.xlw.security.filter.xss.wrapper;

import java.io.Serializable;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

public class XssNoneWrapper extends FilterWrapper implements Serializable {
	private static final long serialVersionUID = -5824201835442982702L;

	public XssNoneWrapper(HttpServletRequest request) {
		super(request);
	}

	protected Pattern getPattern() {
		return null;
	}
}
