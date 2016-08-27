/**
 * 
 */
package cn.com.fardo.example.web.config;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author lmq
 *
 */
@Configuration
public class MyConfiguration {
	
	@Bean
	public HttpMessageConverters customConverts(){
		HttpMessageConverter mappingJackson2  = new MappingJackson2HttpMessageConverter();
		
		return new HttpMessageConverters(mappingJackson2);
	}
}
