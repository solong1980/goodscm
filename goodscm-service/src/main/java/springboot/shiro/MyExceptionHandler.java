package springboot.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.utils.JsonUtilTool;

public class MyExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
		ModelAndView mv = new ModelAndView();
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof UnauthenticatedException) {
			CmResult result = CmResult.build(Codes.TOKEN_ERROR);
			attributes.putAll(JsonUtilTool.toJsonObj(result));
		} else if (ex instanceof UnauthorizedException) {
			CmResult result = CmResult.build(Codes.NO_PERMISSION);
			attributes.putAll(JsonUtilTool.toJsonObj(result));
		} else {
			CmResult result = CmResult.build(Codes.FAILURE, ex);
			attributes.putAll(JsonUtilTool.toJsonObj(result));
		}

		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}

}
