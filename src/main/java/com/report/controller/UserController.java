package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {

    @RequestMapping("professor/professorMain")
	public String professorMain() {
		return "professor/main"; // 로그인 한 교수를 위한 메인 페이지 URL
	  }
    @RequestMapping("ta/taMain")
	public String taMain() {
		return "ta/main"; // 로그인 한 ta를 위한 메인 페이지 URL
	  }
}