package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.feign.HelloFeign;

@RestController
public class HelloController {
	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloFallback")	//断路器，方法名，失败后调用方法
	public String hello(@PathVariable String name) {
		return helloFeign.hello(name);
	}
	
	//供断路器来调用，处理特殊异常情况
	public String helloFallback(String name) {
		return "999";		//999缓存 redis，设置“假的值”。降级！
	}
}
