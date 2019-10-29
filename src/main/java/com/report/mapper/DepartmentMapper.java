package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Department; 

@Mapper
public interface DepartmentMapper {
	List<Department> findAll();
}
