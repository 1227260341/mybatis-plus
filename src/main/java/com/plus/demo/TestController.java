package com.plus.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/get")
	public String get() {
		
		return "test success";
	}
	
	
}
