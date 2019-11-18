package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Homework;

@Mapper
public interface HomeworkMapper {
	
	List<Homework> findNotoiceStudents(int notice_no);
	
	void gradeUpdate(int grade, int ranking, int hw_no);
	

}
