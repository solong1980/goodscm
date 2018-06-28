package springboot.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "local")
public class ServletConfigure {

	/**
	 * 代码注册servlet(不需要@ServletComponentScan注解)
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<MyBatisConfigureRefreshServlet> servletRegistrationBean(MyBatisSqlSessionManager manager) {
		return new ServletRegistrationBean<>(new MyBatisConfigureRefreshServlet(manager), "/servlet/mybatis/refresh");
	}

	@Bean
	public MyBatisSqlSessionManager mybatisSessionCache(SqlSessionFactory sessionFactory) throws Exception {
		MyBatisSqlSessionWatcher batisSqlSessionManager = new MyBatisSqlSessionWatcher(sessionFactory);
		batisSqlSessionManager.refreshMapper();
		return batisSqlSessionManager;
	}
}