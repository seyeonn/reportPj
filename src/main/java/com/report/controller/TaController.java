package com.report.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.Ta;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.TaMapper;

@Controller

@RequestMapping("ta")
public class TaController {

	@Autowired TaMapper taMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired ProfessorMapper professorMapper;


	@RequestMapping("taMain")
	public String taMain(Model model, Principal principal) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> taLecture = lectureMapper.findByTaLecture(ta.getTa_no());

		model.addAttribute("ta", ta);
		model.addAttribute("professor", professor);
		model.addAttribute("taLecture", taLecture);


		return "ta/main"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@RequestMapping("information")
	public String information(Model model) {
		return "ta/information"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@RequestMapping("mypage")
	public String mypage(Model model) {
		return "ta/mypage"; // 로그인 한 ta를 위한 메인 페이지 URL
	}


}
