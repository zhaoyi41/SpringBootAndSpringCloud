package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired
	private RestTemplate restTemplate;	//通过这个对象访问远程提供者
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		//调用服务提供者
		String url  = "http://localhost:7900/hello/"+name;
		String msg = restTemplate.getForObject(url, String.class);
		
		return msg;
	}
}
