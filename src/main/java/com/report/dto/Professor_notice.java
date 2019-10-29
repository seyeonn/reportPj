package com.report.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Professor_notice {

	@Getter
	@Setter
	int notice_no;
	int leture_no;
	int professor_no;
	String header;
	String title;
	String content;
	Date submitDate;
	Date deadline;
	Date deadline_add;
	Date perfect_score;
}
