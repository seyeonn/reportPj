package com.report.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	int no;
	String id;
	String password1;
	String name;
	String email;
	String userType;
	int department_no;
	String password_question;
    String password_answer;

}
