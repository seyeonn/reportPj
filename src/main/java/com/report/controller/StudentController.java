package com.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Department;
import com.report.dto.Student;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.StudentMapper;

@Controller

public class StudentController {
    @RequestMapping("student/studentMain")
	public String studentMain(Model model, HttpServletRequest request) {
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL
		
	  }

}
