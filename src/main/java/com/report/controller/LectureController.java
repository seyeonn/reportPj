package com.report.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.service.LectureService;
import com.report.service.ProfessorLectureService;
import com.report.service.TaService;

@Controller
@RequestMapping("professor")
public class LectureController {
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;

	@Autowired
	ProfessorLectureMapper professorLectureMapper;

	@Autowired
	private TaService taService;

	@Autowired
	private LectureService lectureService;

	// 강좌개설 옆에 각자 교수님이 개설한 강좌 목록 출력위한 것
	@Autowired
	private ProfessorLectureService professorLectureService;

//	@GetMapping("createlecture")
//	public String registerLecture1(Model model, Lecture lecture, Principal principal){
//		Professor professor = professorMapper.findByProfessorId(principal.getName());
//		List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
//		List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
//		model.addAttribute("professorLecture1", professorLecture1);
//		model.addAttribute("professorLecture2", professorLecture2);
//		model.addAttribute("professor", professor);
//
//		ProfessorLecture professorLecture = new ProfessorLecture();
//
//		model.addAttribute("ta", taService.findAll());
//		model.addAttribute("lecutre", lecture);
//		professor.setTa_no(professor.getTa_no());
//
//		return "professor/createlecture";
//
//	}

	@PostMapping("createlecture")
	public String registerLecture(@Valid Lecture lecture, BindingResult bindingResult, Model model, Principal principal, ProfessorLecture professorLecture){
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
		List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
		model.addAttribute("professorLecture1", professorLecture1);
		model.addAttribute("professorLecture2", professorLecture2);
		model.addAttribute("professor", professor);
		if(bindingResult.hasErrors()){
			model.addAttribute("ta", taService.findAll());
			return "professor/createlecture";
		}

		lectureService.professorSave(lecture,professorLecture, professor);
		return "redirect:createlecture";
	}


	@RequestMapping(value="createlecture", method=RequestMethod.GET)
	public String createlecture(Model model, Lecture lecture, Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
		List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
		model.addAttribute("professorLecture1", professorLecture1);
		model.addAttribute("professorLecture2", professorLecture2);
		model.addAttribute("professor", professor);

        ProfessorLecture professorLecture = new ProfessorLecture();

		model.addAttribute("ta", taService.findAll());
		model.addAttribute("lecutre", lecture);
		professor.setTa_no(professor.getTa_no());

		return "professor/createlecture";

	}

	@RequestMapping(value="createlecture", method=RequestMethod.POST, params="cmd=delete")
	public String deletelecture(Model model, @RequestParam("id") int id, Principal principal, Lecture lecture, ProfessorLecture professorLecture) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
		List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
		model.addAttribute("professorLecture1", professorLecture1);
		model.addAttribute("professorLecture2", professorLecture2);
		model.addAttribute("professor", professor);
		lectureService.deleteEntity(id);
	    return "redirect:createlecture";
	}

//	@RequestMapping(value="createlecture", method=RequestMethod.POST, params="cmd=insert")
//	public String createlecture(Model model, @RequestParam("id") int id, BindingResult bindingResult, Principal principal, Lecture lecture, ProfessorLecture professorLecture) {
//		Professor professor = professorMapper.findByProfessorId(principal.getName());
//		List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
//		List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
//		model.addAttribute("professorLecture1", professorLecture1);
//		model.addAttribute("professorLecture2", professorLecture2);
//		model.addAttribute("professor", professor);
//		if(bindingResult.hasErrors()){
//			model.addAttribute("ta", taService.findAll());
//			return "professor/createlecture";
//		}
//
//		lectureService.professorSave(lecture,professorLecture, professor);
//	    return "professor/createlecture";
//	}
//	@RequestMapping(value="lectures", method=RequestMethod.POST, params="cmd=insert")
//	public String lectures(Model model, Lecture lecture) {
//	    ....lecture 등록하고
//	    model.addAttribute("databases", 디비목록조회);
//	    return "professor/lectures";
//	}

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