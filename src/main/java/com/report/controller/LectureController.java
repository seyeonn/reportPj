package com.report.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.Lecture;
import com.report.service.LectureService;
import com.report.service.ProfessorLectureService;
import com.report.service.TaService;

@Controller
public class LectureController {

	@Autowired
	private TaService taService;

	@Autowired
	private LectureService lectureService;

	// 강좌개설 옆에 각자 교수님이 개설한 강좌 목록 출력위한 것
	@Autowired
	private ProfessorLectureService professorLectureService;


	@GetMapping("createlecture")
	public String registerLecture(Model model, Lecture lecture){
		model.addAttribute("ta", taService.findAll());
		return "professor/createlecture";
	}
	//

	@PostMapping("createlecture")
	public String registerLecture(@Valid Lecture lecture, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("ta", taService.findAll());
			return "professor/createlecture";
		}

		lectureService.save(lecture);
		return "professor/createlecture";
	}


	@GetMapping(value="delete")
	public String delete(Model model, HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0", required = false) int n_id) {
		if(request.isRequestedSessionIdValid()) {
			return "redirect:createlecture";
		}
		return "redirect:createlecture";
	}

	@RequestMapping("registerSuccess")
	public String registerSuccess(Model model, HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0", required = false) int n_id){
		return "redirect:createlecture";
	}

}
