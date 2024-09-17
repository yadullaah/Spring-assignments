package com.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.entity.Harddisk;

@RestController
public class HarddiskController {
	@Autowired
	private Harddisk harddisk;

	@GetMapping("/harddisks")
	public Harddisk getHarddisk() {
		return harddisk;

	}

}
