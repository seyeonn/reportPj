package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.report.dto.Lecturefile;
import com.report.model.Pagination;

@Mapper
public interface LecturefileMapper {

	Lecturefile findByNo(int no);
	void insert(Lecturefile uploadedFile);
	void deleteByNo(int id);

	List<Lecturefile> findAll(@Param("id") int id, @Param("pagination") Pagination pagination);
	int count(int id);
}
