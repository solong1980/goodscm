package springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xlw.goodscm.Consts;

@WebListener
public class IndexListener implements ServletContextListener {
	private Log log = LogFactory.getLog(IndexListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().setInitParameter(Consts.FILE_STORE_DIRECTORY_KEY, Consts.DIR_STORE);
		log.info("IndexListener contextInitialized");
		// ClassLoadUtil.contextInitialized(servletContextEvent);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}