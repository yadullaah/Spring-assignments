package com.model.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello!";
	}

}
