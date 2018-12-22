package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	//应该加载git的属性在读取这个注解之前
	@Value("${jtver}")		//获取git上属性jtver，${jtver}和属性文件中的key一致
	private String jtver;
	 
	@RequestMapping("/hello"
			+ "")
	public String hello() {
		return "SpringCloud config："+jtver;	 //访问git
	}
}
