package com.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.entity.Computer;
import com.model.entity.Harddisk;

@Configuration
public class ApplicationConfig {
	@Bean
	Computer getComputer() {
		return new Computer();

	}
	
	@Bean
	Harddisk getHarddisk() {
		return new Harddisk();

	}
}
