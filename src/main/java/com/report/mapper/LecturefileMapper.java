package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Lecturefile;

@Mapper
public interface LecturefileMapper {

	Lecturefile findByNo(int no);
	List<Lecturefile> findAll(int id);
	void insert(Lecturefile uploadedFile);
	void deleteByNo(int id);
}
