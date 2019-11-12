package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Homework;

@Mapper
public interface HomeworkMapper {
	
	List<Homework> findNotoiceStudents();
	void scoreUpdate(int hw_no, Integer score);
}
