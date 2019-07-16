package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// TODO
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现；
//		2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；
//@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.springBoot","com.testPackage"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}
