package com.report.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Department;
import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.Ta;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.TaMapper;
import com.report.service.TaService;

@Controller
@RequestMapping("professor")
public class ProfessorController {

      @Autowired ProfessorMapper professorMapper;
      @Autowired TaMapper taMapper;
      @Autowired DepartmentMapper departmentMapper;
      @Autowired private TaService taService;

      @RequestMapping("professorMain")
  	public String professorMain(Model model,Principal principal) {
    	Professor professor = professorMapper.findByProfessorId(principal.getName());
      	model.addAttribute("professor", professor);
  		return "professor/main"; // 로그인 한 교수를 위한 메인 페이지 URL
  	  }

      @RequestMapping("notice")
  	public String notice(Model model,Principal principal) {
    	Professor professor = professorMapper.findByProfessorId(principal.getName());
      	model.addAttribute("professor", professor);
  		return "professor/notice"; // 과제 및 공지 페이지
  	  }

      @RequestMapping("posting")
  	public String posting(Model model,Principal principal) {
    	Professor professor = professorMapper.findByProfessorId(principal.getName());
      	model.addAttribute("professor", professor);
  		return "professor/posting"; // 과제 및 공지 작성 페이지
  	  }

      @RequestMapping("lecturefile")
    	public String lecturefile(Model model,Principal principal) {
      	Professor professor = professorMapper.findByProfessorId(principal.getName());
        	model.addAttribute("professor", professor);
    		return "professor/lecturefile"; // 강의자료 페이지
    	  }

      @RequestMapping("mypage")
    	public String mypage(Model model,Principal principal) {
      	Professor professor = professorMapper.findByProfessorId(principal.getName());
        	model.addAttribute("professor", professor);
    		return "professor/mypage"; // 마이페이지
    	  }

      @RequestMapping("information")
    	public String information(Model model,Principal principal) {
      	Professor professor = professorMapper.findByProfessorId(principal.getName());
        	model.addAttribute("professor", professor);
    		return "professor/information"; // 도움말 페이지
    	  }

      @RequestMapping("noticecontent")
    	public String noticecontent(Model model,Principal principal) {
      	Professor professor = professorMapper.findByProfessorId(principal.getName());
        	model.addAttribute("professor", professor);
    		return "professor/noticecontent"; //과제 및 공지 내용 페이지
    	  }

      @RequestMapping("studentnotice")
     	public String studentnotice(Model model,Principal principal) {
       	Professor professor = professorMapper.findByProfessorId(principal.getName());
         	model.addAttribute("professor", professor);
     		return "professor/studentnotice"; // 학생 게시판 페이지
     	  }

      @RequestMapping("inputscore")
     	public String inputscore(Model model,Principal principal) {
       	Professor professor = professorMapper.findByProfessorId(principal.getName());
         	model.addAttribute("professor", professor);
     		return "professor/inputscore"; // 학생 게시판 페이지
     	  }
      @GetMapping(value="taapprove")
      public String taapprove(Model model) {
         Professor professor = new Professor();
         Ta ta = new Ta();
         List<Department> departments = departmentMapper.findAll();
         model.addAttribute("professor", professor);
         model.addAttribute("departments", departments);
         return "professor/taapprove";
      }

      @GetMapping("createlecture")
    	public String registerLecture(Model model, Lecture lecture, Principal principal){
      	  Professor professor = professorMapper.findByProfessorId(principal.getName());
         	model.addAttribute("professor", professor);
//    		ProfessorLecture professorlecture = professorlectureMapper.findByProfessorLectureName(principal.getName());
//    		model.addAttribute("professorlecture", professorlecture);
    		model.addAttribute("ta", taService.findAll());
    		return "professor/createlecture";

      }
}