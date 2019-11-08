package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Lecture;
import com.report.dto.Professor;

@Mapper
public interface ProfessorMapper {
	Professor findOne(int professor_no);
	Professor findByProfessorName(String name);
	Professor findByProfessorId(String id);
	List<Lecture> findByProfessorLecture1(String id);
	List<Lecture> findByProfessorLecture2(String id);
	List<Professor> findAll();
	void insert(Professor professor);
	void update(Professor professor);
	void delete(int professor_no);
	void taUpdate(int ta_no, int professor_no);
	List<Lecture> findBytaNO(String id);
	List<Lecture> findBytaYES(String id);
}
