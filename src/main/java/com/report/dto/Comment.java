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
	int depth;
	String content;
	int parent;
}
