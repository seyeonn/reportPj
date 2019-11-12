package com.report.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Homework {

	int hw_no;
	int student_no;
	int notice_no;
	String file_name;
	int file_size;
	String submitdate;
	Integer grade;
	int rank;
	
	Student student;
	
	
	
}
