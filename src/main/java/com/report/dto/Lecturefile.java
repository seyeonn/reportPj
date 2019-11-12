package com.report.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lecturefile {

	int no;
	String file_name;
	int file_size;
	Date file_time;
	byte[] data;
	int lecture_no;
}
