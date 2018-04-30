package springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebListener
public class IndexListener implements ServletContextListener {
	private Log log = LogFactory.getLog(IndexListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.info("IndexListener contextInitialized");
		// ClassLoadUtil.contextInitialized(servletContextEvent);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}