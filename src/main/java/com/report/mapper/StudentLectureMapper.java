package com.report.mapper;

import java.util.List;

import com.report.dto.Lecture;
import com.report.dto.StudentLecture;

public interface StudentLectureMapper {
	StudentLecture fineOne(int lecture_no);
	StudentLecture findByLectureName(String lecture_name);
	List<Lecture> findAll();
	void insert(Lecture lecture);
	void update(Lecture lecture);
	void delete(int lecture_no);
}
