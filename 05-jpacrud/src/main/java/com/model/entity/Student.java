package com.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.RequiredArgsConstructor;


@Entity // if using entity no need to use table or column
//@Table(name = "students")
@RequiredArgsConstructor //  no need to use NoArgsConstructor or AllArgsConstructor
@AllArgsConstructor
@Data //if using data we dont need to use getter, setter, constructor
public class Student {

	@Column(name = "rollnumber")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnumber;

	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;

}
