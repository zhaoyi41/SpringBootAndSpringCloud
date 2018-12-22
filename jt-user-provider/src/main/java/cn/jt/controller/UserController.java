package cn.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.pojo.User;
import cn.jt.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	//不拆，给Feign，不支持分拆
	@RequestMapping("/user/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/user/find/{name}")
	public List<User> find(User user){
		return userService.find(user);
	}
	@RequestMapping("/user/add/{name}/{birthday}/{address}")
	public String add(User user){
	    try {
		    userService.add(user);
		    return "add success";
	    }catch (Exception e) {
			e.printStackTrace();
			return "add error";
		}
	}
	@RequestMapping("/user/update/{name}/{birthday}/{address}/{id}")
	public String update(User user){
		try {
			userService.update(user);
			return "update success";
		}catch(Exception e) {
			e.printStackTrace();
			return "update error";
		}
	}
	@RequestMapping("/user/delect/{id}")
	public String delect(@PathVariable("id") Long id){
		try {
			userService.delete(id);
			return "delete success";
		}catch(Exception e) {
			e.printStackTrace();
			return "delete error";
		}
	}
}





