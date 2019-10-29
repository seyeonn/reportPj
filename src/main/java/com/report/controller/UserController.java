package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

	@RequestMapping("login")
	public static String login() {
		return "user/login";
	}

	@RequestMapping("option")
	public static String option() {
		return "user/option";
	}

}