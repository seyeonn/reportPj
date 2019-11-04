package com.report.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.ProfessorLecture;

@Mapper
public interface ProfessorLectureMapper {
	ProfessorLecture findOne(int professor_lecture_no);

	ProfessorLecture findByProfessorNo(int professor_no);
	ProfessorLecture findByLectureNo(int lecture_no);
	void insert(ProfessorLecture professorLecture);

}
