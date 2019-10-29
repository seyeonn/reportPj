package com.report.mapper;

import java.util.List;

import com.report.dto.StudentLecture;

public interface StudentLectureMapper {
	StudentLecture findOne(int student_lecture_no);
	List<StudentLecture> findAll();

}
