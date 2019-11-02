package com.report.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class StudentController {

    @RequestMapping("student/studentMain")
	public String studentMain(Model model, HttpServletRequest request) {
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL

	 }
    @RequestMapping("student/lecture")
 	public String studentlecture(Model model, HttpServletRequest request) {
 		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

 	 }

}
