package com.report.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student_notice {
	
	int studentnotice_no;
	int lecture_no;
	int student_no;
	String title;
	String content;
	Date submitdate;
}
