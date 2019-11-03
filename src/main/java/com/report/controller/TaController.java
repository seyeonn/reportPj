package com.report.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Ta;
import com.report.mapper.TaMapper;

@Controller

@RequestMapping("ta")
public class TaController {

	@Autowired TaMapper taMapper;

    @RequestMapping("taMain")
	public String taMain(Model model, Principal principal) {
    	Ta ta = taMapper.findByTaId(principal.getName());
    	model.addAttribute("ta", ta);
		return "ta/main"; // 로그인 한 ta를 위한 메인 페이지 URL
	  }
}
