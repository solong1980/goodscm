package com.xlw.security.filter.xss.mode;

import java.util.Iterator;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;

public abstract class FilterMode {
	protected Pattern pattern = null;

	public FilterMode() {
		setPattern();
	}

	public boolean isValidInput(ServletRequest request) {
		if (this.pattern == null)
			return true;
		Iterator<String[]> it = null;
		try {
			it = request.getParameterMap().values().iterator();
			String[] values = null;
			while (it.hasNext()) {
				values = it.next();
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					if (isMatch(value)) {
						return false;
					}
				}
			}
		} catch (Exception localException) {
		}
		return true;
	}

	protected abstract void setPattern();

	protected abstract boolean isMatch(String paramString);

	public abstract String returnGegEx();
}
