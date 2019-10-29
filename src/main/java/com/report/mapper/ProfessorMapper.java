package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Professor;

@Mapper
public interface ProfessorMapper {
	Professor findOne(int professor_no);
	Professor findByProfessorName(String professor_name);
	List<Professor> findAll();
	void insert(Professor professor);
	void update(Professor professor);
	void delete(int professor_no);
}
