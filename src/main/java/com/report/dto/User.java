package com.report.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	int no;
	String loginId;
	String password;
	String name;
	String email;
	String userType;
	int department_no;

}
