package cn.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.jt.sso.mapper")
public class RunAppJtSso {

	public static void main(String[] args) {
		SpringApplication.run(RunAppJtSso.class, args);
	}

}
