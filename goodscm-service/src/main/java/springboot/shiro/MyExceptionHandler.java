package springboot.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.xlw.goodscm.GoodsCMException;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.utils.JsonUtilTool;

public class MyExceptionHandler implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

	String pattern = ".*(Exception:\\s+Duplicate entry.*for key '(.*)')";
	Pattern duplicateKeyRex = Pattern.compile(pattern);

	public MyExceptionHandler() {
		super();
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception ex) {
		logger.error("method:[" + o.toString() + "] error", ex);
		ModelAndView mv = new ModelAndView();
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof UnauthenticatedException) {
			CmResult result = CmResult.build(Codes.TOKEN_ERROR);
			attributes.putAll(JsonUtilTool.toJsonObj(result));
		} else if (ex instanceof UnauthorizedException) {
			CmResult result = CmResult.build(Codes.NO_PERMISSION);
			attributes.putAll(JsonUtilTool.toJsonObj(result));
		} else if (ex instanceof GoodsCMException) {
			CmResult result = CmResult.build(((GoodsCMException) ex).getCode(), ex);
			attributes.putAll(JsonUtilTool.toJsonObj(result));
		} else if (ex instanceof DuplicateKeyException) {
			String message = ex.getMessage();
	 
			Matcher m = duplicateKeyRex.matcher(message);
			
			CmResult result = CmResult.build(Codes.FAILURE, ex);
			if (m.find()) {
				String group = m.group(2);
				if("short_name".equals(group))
					result = CmResult.build(Codes.DUPLICATE_SHORTNAME);
				if("name".equals(group))
					result = CmResult.build(Codes.DUPLICATE_NAME);
				if("code".equals(group))
					result = CmResult.build(Codes.DUPLICATE_CODE);
			}
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
