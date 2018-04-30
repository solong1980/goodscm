package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode;
import com.xlw.goodscm.pojo.CmResult;

@SpringBootApplication
@MapperScan("com.xlw.goodscm.dao") // 将项目中对应的mapper类的路径加进来就可以了
@ComponentScan(value = { "com.xlw.goodscm.controller", "com.xlw.goodscm.service" })
@ComponentScan(value= {"springboot.shiro"})
@RestController
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
	public CmResult index() throws Exception {
		// return "login";
		return CmResult.build(ReturnCode.Codes.NO_LOGIN);
	}
}