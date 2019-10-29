package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Ta;

@Mapper
public interface TaMapper {

	
	void insert(Ta ta);
	void update(Ta ta);
	void delete(int ta_no);
}
