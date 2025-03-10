package com.model.config;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.model.entity.Employee;

@Configuration
public class EmployeeBatchExportConfig {

	@Bean
	public JdbcCursorItemReader<Employee> databaseReader(DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Employee>().dataSource(dataSource).name("EmployeeDatabaseReader")
				.sql("SELECT employee_id, name, salary FROM employees")
				.rowMapper(new BeanPropertyRowMapper<>(Employee.class)).build();
	}

	@Bean
	public FlatFileItemWriter<Employee> csvWriter() {
		return new FlatFileItemWriterBuilder<Employee>().name("EmployeeCsvWriter")
				.resource(new FileSystemResource("C:/Users/Yadullah.Maghrabi/Desktop/employees.csv")).delimited()
				.delimiter(",").names("employeeId", "name", "salary").build();
	}

	@Bean
	public Step exportStep(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
			JdbcCursorItemReader<Employee> databaseReader, FlatFileItemWriter<Employee> csvWriter) {

		return new StepBuilder("exportDatabaseToCsvStep", jobRepository)
				.<Employee, Employee>chunk(10, transactionManager).reader(databaseReader).writer(csvWriter).build();
	}

	@Bean
	public Job exportJob(JobRepository jobRepository, Step exportStep, JobCompletionNotificationListener listener) {
		return new JobBuilder("exportJob", jobRepository).listener(listener).start(exportStep).build();
	}
}
