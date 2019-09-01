package springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		System.out.println("=============================================");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// .apis(RequestHandlerSelectors.basePackage("com.ganjiangps.wangdaibus.controller.test"))
				// .apis(RequestHandlerSelectors.basePackage("com.ganjiangps.wangdaibus.controller"))
				// .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) 
				// //只显示加了注解的api
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("管理系统").description("powered by By-Health").termsOfServiceUrl("http://localhost:9905/swagger-ui.html")
				// .contact(contact)
				.version("1.0").build();
	}

}