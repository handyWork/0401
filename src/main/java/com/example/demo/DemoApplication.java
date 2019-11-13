package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

// TODO
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//注：继承SpringBootServletInitializer这个接口并重写configure（）方法  是为了部署项目时使用的


//1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现；
//		2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；
//@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.springBoot","com.testPackage"})
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
}
