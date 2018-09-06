package com.xlw.zerg;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Configuration
public class ZergConfig implements WebMvcConfigurer {

	@Bean("tokenCache")
	public Cache<String, String> createTokenCache() {
		return CacheBuilder.newBuilder().initialCapacity(30).expireAfterAccess(10, TimeUnit.HOURS).build();
	}

}