/**
 * 
 */
package cn.com.fardo.example.web.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lmq
 *
 */
public class CustomJsonHttpMessageConverter implements HttpMessageConverter {
	//jackson的json映射类
	private ObjectMapper mapper = new ObjectMapper();
	//
	private List supportedMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);
	/*  判断转换器是否可以将输入内容转换成Java类型
	 * @see org.springframework.http.converter.HttpMessageConverter#canRead(java.lang.Class, org.springframework.http.MediaType)
	 */
	public boolean canRead(Class clazz, MediaType mediaType) {
		if(mediaType  == null){
			return true;
		}
		for(Object obj : this.getSupportedMediaTypes()){
			MediaType supportedMediaType = (MediaType)obj;
			if(supportedMediaType.includes(mediaType)){
				return true;
			}
		}
		return false;
	}

	/* 判断转换器是否可以将Java类型转换成指定输出内容
	 * @see org.springframework.http.converter.HttpMessageConverter#canWrite(java.lang.Class, org.springframework.http.MediaType)
	 */
	public boolean canWrite(Class clazz, MediaType mediaType) {
		if(mediaType == null || MediaType.ALL.equals(mediaType)){
			return true;
		}
		for(Object obj : this.getSupportedMediaTypes()){
			MediaType supportedMediaType = (MediaType)obj;
			if(supportedMediaType.includes(mediaType)){
				return true;
			}
		}
		return false;
	}

	/*  获得该转换器支持的MediaType
	 * @see org.springframework.http.converter.HttpMessageConverter#getSupportedMediaTypes()
	 */
	public List getSupportedMediaTypes() {
		// TODO Auto-generated method stub
		return supportedMediaTypes;
	}

	/* 读取请求内容，将其中的Json转换成Java对象
	 * @see org.springframework.http.converter.HttpMessageConverter#read(java.lang.Class, org.springframework.http.HttpInputMessage)
	 */
	public Object read(Class clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return mapper.readValue(inputMessage.getBody(), clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.http.converter.HttpMessageConverter#write(java.lang.Object, org.springframework.http.MediaType, org.springframework.http.HttpOutputMessage)
	 */
	public void write(Object t, MediaType contentType,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		mapper.writeValue(outputMessage.getBody(),t);
		
	}

}
