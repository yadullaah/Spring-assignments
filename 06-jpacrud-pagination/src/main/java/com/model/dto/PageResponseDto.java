package com.model.dto;

import java.util.List;

import com.model.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDto {

	private long totalElements;
	private int totalPages;
	private int size;
	private List<Student> content;

}
