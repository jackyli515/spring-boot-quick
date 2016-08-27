/**
 * 
 */
package cn.com.fardo.example;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 *EnableAutoConfiguration
 * Spring Boot会自动根据你jar包的依赖来自动配置项目。例如当你项目下面有HSQLDB的依赖时，Spring Boot会创建默认的内存数据库的数据源DataSource，如果你自己创建了DataSource，
 * Spring Boot就不会创建默认的DataSource。
 * 
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:
 * @author lmq
 *
 */
@SpringBootApplication
//@Configuration
//@ComponentScan
@RestController
//@EnableAutoConfiguration//Spring Boot建议只有一个带有该注解的类。
public class Application {
	@RequestMapping("/")
	public String home(){
		return "Hello World";
	}
	@RequestMapping("/now")
	public String now(){
		return "现在时间是："+(new Date());
	}
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
