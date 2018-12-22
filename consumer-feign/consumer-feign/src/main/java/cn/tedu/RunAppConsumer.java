package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients		//启动Feign访问形式
public class RunAppConsumer {
	public static void main(String[] args) {
		SpringApplication.run(RunAppConsumer.class, args);
	}

}
