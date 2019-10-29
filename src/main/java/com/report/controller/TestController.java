package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("login")
	public static String login() {
		return "user/login";
	}
	@RequestMapping("studentmain")
	public static String studentmain() {
		return "student/main";
	}
	@RequestMapping("professormain")
	public static String professormain() {
		return "professor/main";
	}
	@RequestMapping("tamain")
	public static String tamain() {
		return "ta/main";
	}
	@RequestMapping("notice")
	public static String notice() {
		return "professor/notice";
	}
}
