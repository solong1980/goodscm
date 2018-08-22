package com.xlw.security.filter.xss;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.xlw.security.filter.xss.mode.FilterMode;
import com.xlw.security.filter.xss.mode.NoneFilterMode;
import com.xlw.security.filter.xss.mode.SpecialCharacterFilterMode;
import com.xlw.security.filter.xss.mode.TagFilterMode;
import com.xlw.security.filter.xss.pattern.PatternUtil;

public class XssAlertFilter implements Filter, Serializable {
	private static final long serialVersionUID = -8336087787470861608L;
	private FilterMode mode;
	private String filterMode;
	private String urlExclude;
	private Pattern patternExclude = null;
	private String encoding;

	public void init(FilterConfig config) throws ServletException {
		this.filterMode = config.getInitParameter("filterMode");
		if ((this.filterMode == null) || ("".equals(this.filterMode))) {
			this.filterMode = "BASIC";
		}

		if ("BASIC".equalsIgnoreCase(this.filterMode)) {
			this.mode = new SpecialCharacterFilterMode();
		} else if ("TAG".equalsIgnoreCase(this.filterMode)) {
			this.mode = new TagFilterMode();
		} else if ("NONE".equalsIgnoreCase(this.filterMode)) {
			this.mode = new NoneFilterMode();
		} else {
			this.mode = new NoneFilterMode();
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
		if (this.mode.isValidInput(request)) {
			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('Input contains one or more which are Forbidden：[" + this.mode.returnGegEx()
					+ "]');window.history.go(-1)</script>");
			out.flush();
			out.close();
		}
	}

	public void destroy() {
	}
}
