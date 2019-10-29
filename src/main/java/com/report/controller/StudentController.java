package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.report.dto.Department;
import com.report.dto.Student;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.StudentMapper;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired StudentMapper studentMapper;
	@Autowired DepartmentMapper departmentMapper;
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String create(Model model) {
		Student student = new Student();
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("student", student);
		model.addAttribute("departments", departments);
		return "student/signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String create(Model model, Student student) {
		studentMapper.insert(student);
		return "redirect:user/login";
	}
	
}
