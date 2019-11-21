package com.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLecture {

	int student_lecture_no;
	int lecture_no;
	int student_no;

	String title;
	String lecture_name;
	String file_name;
}
