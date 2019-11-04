package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Department;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DepartmentMapper {
	List<Department> findAll();

	Department findByDepartmentNo();
}
