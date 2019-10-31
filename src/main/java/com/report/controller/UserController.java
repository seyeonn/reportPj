package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

	@RequestMapping("login")
	public static String login() {
		return "guest/login";
	}

	@RequestMapping("option")
	public static String option() {
		return "guest/option";
	}

	//바꾼것
    @RequestMapping("student/studentMain")
	public String studentMain() {
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL
	  }
    @RequestMapping("professor/professorMain")
	public String professorMain() {
		return "professor/main"; // 로그인 한 교수를 위한 메인 페이지 URL
	  }
    @RequestMapping("ta/taMain")
	public String taMain() {
		return "ta/main"; // 로그인 한 ta를 위한 메인 페이지 URL
	  }
}