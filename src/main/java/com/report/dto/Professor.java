package com.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor {

	int professor_no;
	String id;
	String name;
	int department_no;
	String professor_email;
	String professor_phone;
	String password1;
	String password2;
	String password_question;
	String password_answer;
	int ta_no;
	String userType="교수";

}
