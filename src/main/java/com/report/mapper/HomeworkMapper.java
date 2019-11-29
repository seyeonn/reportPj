package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Homework;

@Mapper
public interface HomeworkMapper {
	
	List<Homework> findNotoiceStudents(int notice_no);
	
	void gradeUpdate(int grade, int hw_no);
	
	void rankUpdate(int ranking, int hw_no);
	
	void noSubmit(int student_no, int professornotice_no);
}
