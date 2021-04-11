package com.inovaitsys.insurance.client.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class InsuranceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${insurance.provider.url}")
	private String url;
	
	@GetMapping("/plans")
	public List<String> getPlans(){
		System.out.println(url);
		List<String> plans=restTemplate.getForObject(url, List.class);
		return plans;
	}

}
