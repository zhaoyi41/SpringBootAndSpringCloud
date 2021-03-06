package cn.jt.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.common.vo.SysResult;
import cn.jt.sso.feign.UserFeign;

@RestController
public class UserController {
	@Autowired
	private UserFeign userFeign;

	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable String param,@PathVariable Integer type) {
		return userFeign.check(param, type);
	}
}
