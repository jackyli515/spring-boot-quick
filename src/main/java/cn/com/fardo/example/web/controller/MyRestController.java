/**
 * 
 */
package cn.com.fardo.example.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.fardo.example.domain.User;

/**
 * @author lmq
 *
 */
@RestController
@RequestMapping(value="/users")
public class MyRestController {
	@RequestMapping(value="/{user}",method=RequestMethod.GET)
	public User getUser(@PathVariable Long user){
		User u = new User();
		u.setMobile("13806092190");
		u.setUserId(user);
		u.setName("j"+user);
		return u;
	}
	@RequestMapping(value="/{user}/customers",method=RequestMethod.GET)
	List<User> getUserCustomers(@PathVariable Long user){
		
		return null;
	}
	@RequestMapping(value="/{user}",method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable Long user){
		return null;
	}
}
