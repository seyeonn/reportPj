package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.report.dto.Lecture;
import com.report.model.Pagination;

@Mapper
public interface TimelineMapper {

	List<Lecture> findAllByStudent(@Param("student_no") int student_no, @Param("pagination") Pagination pagination);
	int countByStudent(int student_no);

	List<Lecture> findAllByTa(@Param("ta_no") int ta_no, @Param("pagination") Pagination pagination);
	int countByTa(int ta_no);

	List<Lecture> findAllByProfessor(@Param("professor_no") int professor_no, @Param("pagination") Pagination pagination);
	int countByProfessor(int professor_no);


}
