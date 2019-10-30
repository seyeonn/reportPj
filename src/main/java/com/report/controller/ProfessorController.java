package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.report.dto.Department;
import com.report.dto.Professor;
import com.report.dto.Ta;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.TaMapper;

@Controller
public class ProfessorController {

		@Autowired ProfessorMapper professorMapper;
		@Autowired TaMapper taMapper;
		@Autowired DepartmentMapper departmentMapper;

		@GetMapping(value="professorsignup")
		public String create(Model model) {
			Professor professor = new Professor();
			Ta ta = new Ta();
			List<Department> departments = departmentMapper.findAll();
			model.addAttribute("professor", professor);
			model.addAttribute("ta", ta);
			model.addAttribute("departments", departments);
			return "professor/signup";
		}

		@PostMapping(value="professorsignup")
		public String create(Model model, Professor professor, Ta ta) {
			professorMapper.insert(professor);
			taMapper.insert(ta);
			return "user/login";
		}

		@GetMapping(value="taapprove")
		public String taapprove(Model model) {
			Professor professor = new Professor();
			Ta ta = new Ta();
			List<Department> departments = departmentMapper.findAll();
			model.addAttribute("professor", professor);
			model.addAttribute("departments", departments);
			return "professor/taapprove";
		}

		@GetMapping(value="mypage")
		public String mypage(Model model) {
			Professor professor = new Professor();
			Ta ta = new Ta();
			List<Department> departments = departmentMapper.findAll();
			model.addAttribute("professor", professor);
			model.addAttribute("departments", departments);
			return "professor/mypage";
		}

}
