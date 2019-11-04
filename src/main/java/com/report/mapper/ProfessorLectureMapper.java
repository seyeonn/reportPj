package com.report.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;

@Mapper
public interface ProfessorLectureMapper {
	ProfessorLecture findOne(int professor_lecture_no);
	ProfessorLecture findByProfessorNo(Professor professor_no);
	ProfessorLecture findByLectureNo(Lecture lecture_no);
	void insert(ProfessorLecture professorLecture);
}
