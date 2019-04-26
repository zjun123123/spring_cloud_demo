package com.atguigu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.lang.reflect.Type;

@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类,接受其它微服务注册进来

@ComponentScan(excludeFilters ={@ComponentScan.Filter(type =FilterType.ANNOTATION,value =EnableEurekaServer.class )} )
public class EurekaServer7001_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServer7001_App.class, args);
	}
}
