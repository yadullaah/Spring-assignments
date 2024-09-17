package com.model.config;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
//import org.springframework.jdbc.core.JdbcTemplate;


@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

	// private final JdbcTemplate jdbcTemplate;

	public JobCompletionNotificationListener() {
		super();
		             // parameter- JdbcTemplate jdbcTemplate
		// this.jdbcTemplate = jdbcTemplate;
	}

}
