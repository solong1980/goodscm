package com.xlw.security.filter.xss.wrapper;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public abstract class FilterWrapper extends HttpServletRequestWrapper {
	private HttpServletRequest orgRequest = null;

	protected abstract Pattern getPattern();

	public FilterWrapper(HttpServletRequest request) {
		super(request);
		this.orgRequest = request;
	}

	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (getPattern() == null) {
			return value;
		}
		if (value != null) {
			value = xssEncode_quick(value);
		}
		return value;
	}

	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (getPattern() == null) {
			return values;
		}
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				values[i] = xssEncode_quick(values[i]);
			}
		}
		return values;
	}

	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (getPattern() == null) {
			return value;
		}
		if (value != null) {
			value = xssEncode_quick(value);
		}
		return value;
	}

	private String xssEncode_quick(String s) {
		return getPattern().matcher(s).replaceAll("＃");
	}

	public HttpServletRequest getOrgRequest() {
		return this.orgRequest;
	}

	public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
		if ((req instanceof FilterWrapper)) {
			return ((FilterWrapper) req).getOrgRequest();
		}

		return req;
	}

	public boolean judgeTagByRegular(String obj) {
		if (getPattern() == null) {
			return true;
		}
		return getPattern().matcher(obj).matches();
	}
}
