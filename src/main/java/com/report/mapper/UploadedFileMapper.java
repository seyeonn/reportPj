package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.UploadedFile;

@Mapper
public interface UploadedFileMapper {

	UploadedFile findByNo(int no);
	List<UploadedFile> findAll();
	void insert(UploadedFile uploadedFile);
	void deleteByNo(int no);
	
}
