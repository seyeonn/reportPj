package com.report.dto;

import lombok.Getter;
import lombok.Setter;

public class Student {
	@Getter
	@Setter
	int student_no;
	String student_id;
	String student_name;
	int department_no;
	String student_email;
	String student_phone;
	String password;
	String password_question;
	String password_answer;
}
