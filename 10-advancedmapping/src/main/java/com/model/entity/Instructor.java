package com.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "instructor")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Instructor {
	
	@Column(name = "instructorId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "qualification")
	private String qualification;

	@JsonIgnore
	@OneToMany(mappedBy = "instructor", cascade = { CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	
	private List<Course> courses;

}
