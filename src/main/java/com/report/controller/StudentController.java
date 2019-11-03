package com.report.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.mapper.StudentMapper;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;

    @RequestMapping("studentMain")
	public String studentMain(Model model, Principal principal) {
    	Object student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL

	 }
    @RequestMapping("lecture")
 	public String studentlecture(Model model, HttpServletRequest request) {
 		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

 	 }

}
