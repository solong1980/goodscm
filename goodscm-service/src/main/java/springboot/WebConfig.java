package springboot;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.CacheControl;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.util.Captcha;

import com.xlw.security.filter.xss.XssAlertFilter;
import com.xlw.util.StringToDateConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/", "classpath:/altcms/")
				.setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());

		registry.addResourceHandler("/altcms/**").addResourceLocations("classpath:/altcms/")
				.setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
	}

	// 配置JSP视图解析器
	@Bean
	public ViewResolver staticViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/static/");
		resolver.setSuffix(".html");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	@Bean
	public ViewResolver altcmsViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/altcms/");
		resolver.setSuffix(".html");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	/**
	 * 文件上传配置
	 * 
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个数据大小
		factory.setMaxFileSize("10240KB"); // KB,MB
		/// 总上传数据大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}

	@Autowired
	@Deprecated
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	@PostConstruct
	@Deprecated
	public void initEditableAvlidation() {
		ConfigurableWebBindingInitializer webBindingInitializer = (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter
				.getWebBindingInitializer();
		if (webBindingInitializer.getConversionService() != null) {
			GenericConversionService conversionService = (GenericConversionService) webBindingInitializer.getConversionService();
			conversionService.addConverter(new StringToDateConverter());
		}

	}

	@Bean
	public FilterRegistrationBean<?> caresXssFilter() throws ServletException {
		XssAlertFilter xssAlertFilter = new XssAlertFilter();
		FilterRegistrationBean<XssAlertFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(xssAlertFilter);
		registration.addUrlPatterns("/*");
		registration.addInitParameter("filterMode", "tag");
		registration.addInitParameter("urlExclude", "servlet");
		registration.setName("goodsCmXssFilter");
		registration.setOrder(1);
		return registration;
	}

	@Bean
	public Captcha createCaptcha() {
		return new Captcha();
	}

}