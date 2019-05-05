package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;



//@RefreshScope
@RestController
public class DeptController
{
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient client;

	@Value("${spring.datasource.dbcp2.min-idle}")
	private String aa;

	@Autowired
	private ContextRefresher contextRefresher;


	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		//contextRefresher.refresh();
		//throw new RuntimeException();

		System.out.println("============================"+aa);
		Dept dept =  service.get(id);
		if(dept ==null)
		{
			throw new RuntimeException();
		}
		return dept;
	}

	@RequestMapping(value = "/dept/aa/{id}", method = RequestMethod.GET)
	public Dept aa(@PathVariable("id") Long id)
	{
		throw new IllegalArgumentException();

	}

	@PostMapping(value = "/dept/body")
	public String dept(@RequestBody  Dept dept)
	{
//		if(bindingResult.hasErrors())
//		{
//			return bindingResult.getFieldError().getDefaultMessage();
//		}
		System.out.println("============================"+dept);
		return dept.getDeptno()+"";
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}


	//	@Autowired
//	private DiscoveryClient client;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
