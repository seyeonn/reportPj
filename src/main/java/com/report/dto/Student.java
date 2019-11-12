package com.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	int student_no;
	String id;
	String name;
	int department_no;
	String student_email;
	String student_phone;
	String password1;
	String password2;
	String password_question;
	String password_answer;
	String userType="학생";
	
	Department department;
}
