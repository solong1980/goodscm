package springboot.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

/**
 * Created by Administrator on 2017/12/11. 自定义sessionId获取
 */
public class MySessionManager extends DefaultWebSessionManager {

	private static final String AUTHORIZATION = "Authorization";

	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

	public MySessionManager() {
		super();
	}

	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		HttpServletRequest http = WebUtils.toHttp(request);
		// Enumeration<String> headerNames = http.getHeaderNames();
		// while(headerNames.hasMoreElements()) {
		// System.out.println(headerNames.nextElement());
		// }
		String id = http.getHeader(AUTHORIZATION);
		// 如果请求头中有 Authorization 则其值为sessionId
		if (!StringUtils.isEmpty(id)) {
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			return id;
		} else {
			// 否则按默认规则从cookie取sessionId
			return super.getSessionId(request, response);
		}
	}
}