package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Lecture;

@Mapper
public interface LectureMapper {
	Lecture fineOne(int lecture_no);
	Lecture findByLectureName(String lecture_name);
	List<Lecture> findAll();
	void insert(Lecture lecture);
	void update(Lecture lecture);
	void delete(int lecture_no);
}
