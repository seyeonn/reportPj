package com.report.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class inputScoreModel {
	
	String id; // 학번
	String name;
	String department_name;
	Date submitdate;
	Integer score;
	String file_no;
}
