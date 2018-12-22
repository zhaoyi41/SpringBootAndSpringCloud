package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class RunAppConsumer {
	public static void main(String[] args) {
		SpringApplication.run(RunAppConsumer.class, args);
	}

}
