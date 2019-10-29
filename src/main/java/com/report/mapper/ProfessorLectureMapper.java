package com.report.mapper;

import java.util.List;

import com.report.dto.ProfessorLecture;

public interface ProfessorLectureMapper {
	ProfessorLecture findOne(int professor_lecture_no);
	List<ProfessorLecture> findAll();
}
