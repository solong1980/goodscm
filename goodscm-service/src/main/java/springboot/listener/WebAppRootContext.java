package springboot.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.WebAppRootListener;

import com.xlw.goodscm.Consts;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebAppRootContext implements ServletContextInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(WebAppRootListener.class);
		servletContext.setInitParameter(Consts.FILE_STORE_DIRECTORY_KEY, Consts.FILE_DIR);
		servletContext.setInitParameter(Consts.SUB_DIRECTORY_KEY, Consts.SUB_DIR);
	}
}