package org.mybatis.spring.boot.autoconfigure;

import java.util.List;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
 
@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "pro")
public class OriginMybatisAutoConfiguration extends MybatisAutoConfiguration{
	public OriginMybatisAutoConfiguration(MybatisProperties properties,
			ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader,
			ObjectProvider<DatabaseIdProvider> databaseIdProvider,
			ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
		super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
	}
}
