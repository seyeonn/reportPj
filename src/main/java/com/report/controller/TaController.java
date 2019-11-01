package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TaController {
    @RequestMapping("ta/taMain")
	public String taMain() {
		return "ta/main"; // 로그인 한 ta를 위한 메인 페이지 URL
	  }
}
