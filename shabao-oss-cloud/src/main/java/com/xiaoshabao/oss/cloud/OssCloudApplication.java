package com.xiaoshabao.oss.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OssCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(OssCloudApplication.class, args);
	}

}
