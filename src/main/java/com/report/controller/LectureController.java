package com.report.controller;

import java.security.Principal;

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
import com.report.dto.Professor;
import com.report.mapper.LectureMapper;
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
   private TaService taService;

   @Autowired
   private LectureService lectureService;

   // 강좌개설 옆에 각자 교수님이 개설한 강좌 목록 출력위한 것
   @Autowired
   private ProfessorLectureService professorLectureService;

   @PostMapping("createlecture")
   public String registerLecture(@Valid Lecture lecture, BindingResult bindingResult, Model model, Principal principal){
	   Professor professor = professorMapper.findByProfessorId(principal.getName());
      	model.addAttribute("professor", professor);
      if(bindingResult.hasErrors()){
         model.addAttribute("ta", taService.findAll());
         return "professor/createlecture";
      }
      lectureService.save(lecture);
      return "professor/createlecture";
   }


   @RequestMapping("createlecture")
   public String studentMain(Model model, Principal principal) {
       Lecture lecture = lectureMapper.findByLectureName(principal.getName());
       model.addAttribute("lecture", lecture);
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