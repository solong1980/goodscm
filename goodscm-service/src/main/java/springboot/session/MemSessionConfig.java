package springboot.session;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springboot.shiro.MySessionManager;

@Configuration
@ConditionalOnProperty(name = "spring.redis.shiro", havingValue = "false")
public class MemSessionConfig {

	@Bean
	public SessionManager sessionManager() {
		// 自定义sessionManager
		MySessionManager mySessionManager = new MySessionManager();
		mySessionManager.setSessionDAO(new MemorySessionDAO());
		return mySessionManager;
	}

	@Bean
	public CacheManager cacheManager() {
		return new MemoryConstrainedCacheManager();
	}
}