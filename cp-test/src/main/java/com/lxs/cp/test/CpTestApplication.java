package com.lxs.cp.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.lxs.cp.test")
public class CpTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpTestApplication.class, args);
	}
}
