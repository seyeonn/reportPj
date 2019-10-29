package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.report.dto.Department;
import com.report.dto.Student;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.StudentMapper;

@Controller
public class StudentController {

	@Autowired StudentMapper studentMapper;
	@Autowired DepartmentMapper departmentMapper;

	@GetMapping(value="studentsignup")
	public String create(Model model) {
		Student student = new Student();
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("student", student);
		model.addAttribute("departments", departments);
		return "student/signup";
	}

	@PostMapping(value="studentsignup")
	public String create(Model model, Student student) {
		studentMapper.insert(student);
		return "user/login";
	}

}
