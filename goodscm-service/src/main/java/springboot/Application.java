package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode;
import com.xlw.goodscm.pojo.CmResult;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, MybatisAutoConfiguration.class })
// @ConfigurationProperties(prefix = "spring")
@MapperScan(value = { "com.xlw.goodscm.dao", "com.xlw.sys.dao" }) // 将项目中对应的mapper类的路径加进来就可以了
@ComponentScan(value = { "com.xlw.goodscm.controller", "com.xlw.sys.controller", "com.xlw.goodscm.service", "com.xlw.broker.service",
		"com.xlw.sys.service" })
@ComponentScan(value = { "springboot.shiro", "springboot.listener", "com.xlw.sys.shiro" })
//@RestController
@EnableCaching
@RequestMapping(path="")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/low")
	public String getLow() {
		return "low";
	}

	@RequestMapping("/login")
	@ResponseBody
	public CmResult login() throws Exception {
		// return "login";
		return CmResult.build(ReturnCode.Codes.NO_LOGIN);
	}

	/**
	 * 管理平台demo
	 */
	@RequestMapping("/index")
	public String index() throws Exception {
		return "index";
	}
	
	@RequestMapping("/main")
	public String main() throws Exception {
		return "main";
	}
	
	@RequestMapping("/orders")
	public String orders() throws Exception {
		return "orders";
	}
}
