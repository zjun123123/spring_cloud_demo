package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}

	@Bean
	public MyFilter myFilter()
	{
		return new MyFilter();
	}
}
