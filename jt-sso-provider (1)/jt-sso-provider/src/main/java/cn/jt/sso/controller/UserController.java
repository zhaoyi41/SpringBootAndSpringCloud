package cn.jt.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.common.vo.SysResult;
import cn.jt.sso.pojo.User;
import cn.jt.sso.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable("param") String param,@PathVariable("type") Integer type) {
		int i  = userService.check(param, type);
		if(i==1) {	//已存在
			return SysResult.ok("true");
		}else {		//不存在
			return SysResult.build(201, "OK", "false");
		}
	}
	
	@RequestMapping("/user/register")
	public SysResult register(User user) {
		String username = userService.register(user);
		return SysResult.ok(username);
	}
	
	@RequestMapping("/user/login")
	public SysResult login(@RequestParam("u") String username,@RequestParam("p")  String password) {
		String ticket = userService.login(username, password);
		return SysResult.ok(ticket);
	}
	
	@RequestMapping("/user/query/{ticket}")
	public SysResult queryByTicket(@PathVariable("ticket") String ticket) {
		String userJson = userService.queryByTicket(ticket);
		return SysResult.ok(userJson);
	}
}





