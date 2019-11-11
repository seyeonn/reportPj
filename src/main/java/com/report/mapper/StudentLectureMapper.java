package com.report.mapper;

import java.util.List;

import com.report.dto.StudentLecture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentLectureMapper {
	StudentLecture findOne(int student_lecture_no);
	void insert(StudentLecture studentLecture);
	void delete(int lecture_no, int student_no);
}
