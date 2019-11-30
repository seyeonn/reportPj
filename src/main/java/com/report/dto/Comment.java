package com.report.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

	int comment_no;
	int notice_no;
	Date notice_date;
	String content;
	int no;

	StudentNotice studentNotice;
	ProfessorNotice professorNotice;
	User user;
	
	//int depth;
	//int parent;
}
