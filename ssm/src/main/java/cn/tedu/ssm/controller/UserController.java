package cn.tedu.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.ssm.pojo.User;
import cn.tedu.ssm.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/find")
	public List<User> find() {
		return userService.find();
	}

	// springClound采用RESTFul，SpringBoot它@PathVariable必须写后面变量@PathVariable("id")
	@RequestMapping("/get/{id}")
	public User get(@PathVariable Integer id) {
		return userService.get(id);
	}

	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(User user) {
		try {
			userService.insert(user);
			return "success";
		} catch (Exception e) {
			return "insert error";
		}
	}

	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String update(User user) {
		try {
			userService.update(user);
			return "success";
		} catch (Exception e) {
			return "update error";
		}
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		try {
			userService.delete(id);
			return "success";
		} catch (Exception e) {
			return "delete error";
		}
	}

}
