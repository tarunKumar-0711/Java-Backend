package com.save.before.dto;

import java.util.List;

import com.save.before.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class RequiredDto {
	
	private Integer pageSize;
	private Integer pageNumber;
	private Integer totalPages;
	private List<Student> students;
	//private List<Student>
}
