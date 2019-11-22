package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dto.Department;
import com.report.mapper.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired DepartmentMapper departmentMapper;
	
	public List<Department> findAll(){
		return departmentMapper.findAll();
	}
	
}
