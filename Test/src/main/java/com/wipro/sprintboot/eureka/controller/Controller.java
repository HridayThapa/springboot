package com.wipro.sprintboot.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class Controller {

	@Autowired
	private RestTemplateBuilder builder;
	
	@Autowired
	private EurekaClient client;
	
	@GetMapping("/")
	public String service()
	{
		RestTemplate restTemplate=builder.build();
		InstanceInfo i= client.getNextServerFromEureka("test",false);
		String url=i.getHomePageUrl()+"test";
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();
	}

}
