package com.report.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorNotice;
import com.report.dto.Ta;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.ProfessorNoticeMapper;
import com.report.mapper.TaMapper;

@Controller

@RequestMapping("ta")
public class TaController {

	@Autowired TaMapper taMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired ProfessorNoticeMapper professorNoticeMapper;

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
	public String information(Model model, Principal principal) {
		Ta ta = taMapper.findByTaId(principal.getName());
		model.addAttribute("ta", ta);
		return "ta/information"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@RequestMapping("studentnotice")
	public String studentnotice(Model model,Principal principal, @RequestParam("id") int id) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		return "professor/studentnotice"; // 학생 게시판 페이지
	}


	@RequestMapping("mypage")
	public String mypage(Model model, Principal principal) {
		Ta ta = taMapper.findByTaId(principal.getName());
		model.addAttribute("ta", ta);
		return "ta/mypage"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@RequestMapping("notice")
	public String notice(Model model, Principal principal, @RequestParam("id") int id) {
		Ta ta = taMapper.findByTaId(principal.getName());
		model.addAttribute("ta", ta);
		Lecture lecture = lectureMapper.findOne(id);
		List<ProfessorNotice>  professorNotices = professorNoticeMapper.list(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professorNotices", professorNotices);
		return "ta/notice"; // 과제 및 공지 페이지
	}

	@RequestMapping("lecturefile")
	public String lecturefile(Model model, Principal principal, @RequestParam("id") int id) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		return "ta/lecturefile"; // 강의자료 페이지
	}

	@GetMapping("noticecontent")
	public String noticecontent(Model model,Principal principal, @RequestParam("id") int id) {
		Ta ta = taMapper.findByTaId(principal.getName());
		ProfessorNotice professorNoice = professorNoticeMapper.findOne(id);
		Lecture lecture = lectureMapper.findOne(professorNoice.getLecture_no());
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		model.addAttribute("professorNotice", professorNoice);
		return "ta/noticecontent"; // 과제 및 공지 작성 페이지
	}

	@RequestMapping("inputscore")
	public String inputscore(Model model,Principal principal) {
		Ta ta = taMapper.findByTaId(principal.getName());
		model.addAttribute("ta", ta);
		return "ta/inputscore"; // 학생 게시판 페이지
	}
}
