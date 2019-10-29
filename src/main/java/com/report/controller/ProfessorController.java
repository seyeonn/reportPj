package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.report.dto.Department;
import com.report.dto.Professor;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.ProfessorMapper;

public class ProfessorController {

		@Autowired ProfessorMapper professorMapper;
		@Autowired DepartmentMapper departmentMapper;

		@GetMapping(value="professorsignup")
		public String create(Model model) {
			Professor professor = new Professor();
			List<Department> departments = departmentMapper.findAll();
			model.addAttribute("student", professor);
			model.addAttribute("departments", departments);
			return "professor/signup";
		}

		@PostMapping(value="professorsignup")
		public String create(Model model, Professor professor) {
			professorMapper.insert(professor);
			return "user/login";
		}
}
