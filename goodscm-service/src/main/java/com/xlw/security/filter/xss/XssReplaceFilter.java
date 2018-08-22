package com.xlw.security.filter.xss;

import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.xlw.security.filter.xss.pattern.PatternUtil;
import com.xlw.security.filter.xss.wrapper.XssNoneWrapper;
import com.xlw.security.filter.xss.wrapper.XssSpecialCharacterWrapper;
import com.xlw.security.filter.xss.wrapper.XssTagWrapper;

public class XssReplaceFilter implements Filter, Serializable {
	private static final long serialVersionUID = 532495536089324309L;
	private HttpServletRequestWrapper wrapper;
	private String filterMode;
	private String urlExclude;
	private Pattern patternExclude = null;
	private String encoding;

	public void init(FilterConfig config) throws ServletException {
		this.filterMode = config.getInitParameter("filterMode");
		if ((this.filterMode == null) || ("".equals(this.filterMode))) {
			this.filterMode = "BASIC";
		}

		this.urlExclude = config.getInitParameter("urlExclude");
		if ((this.urlExclude != null) && (!"".equals(this.urlExclude))) {
			this.patternExclude = PatternUtil.makeUrlExcludePattern(this.urlExclude);
		}
		this.encoding = config.getInitParameter("encoding");
		if ((this.encoding == null) || ("".equals(this.encoding))) {
			this.encoding = "UTF-8";
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding);
		String url = ((HttpServletRequest) request).getRequestURI();
		if ((this.patternExclude != null) && (this.patternExclude.matcher(url).matches())) {
			chain.doFilter(request, response);
			return;
		}

		if ("BASIC".equalsIgnoreCase(this.filterMode)) {
			this.wrapper = new XssSpecialCharacterWrapper((HttpServletRequest) request);
		} else if ("TAG".equalsIgnoreCase(this.filterMode)) {
			this.wrapper = new XssTagWrapper((HttpServletRequest) request);
		} else if ("NONE".equalsIgnoreCase(this.filterMode)) {
			this.wrapper = new XssNoneWrapper((HttpServletRequest) request);
		} else {
			this.wrapper = new XssNoneWrapper((HttpServletRequest) request);
		}
		chain.doFilter(this.wrapper, response);
	}

	public void destroy() {
	}
}

