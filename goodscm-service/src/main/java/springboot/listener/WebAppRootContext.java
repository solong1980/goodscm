package springboot.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
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

	@Value("${file.save.directory}")
	private String fileSaveDiretory;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(WebAppRootListener.class);
		String saveDir = fileSaveDiretory == null ? Consts.DEFAULT_FILE_DIR : fileSaveDiretory;
		servletContext.setInitParameter(Consts.FILE_STORE_DIRECTORY_KEY, saveDir);
		servletContext.setInitParameter(Consts.SUB_DIRECTORY_KEY, Consts.SUB_DIR);
	}
}