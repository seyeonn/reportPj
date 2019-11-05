package com.report.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.Department;
import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.Ta;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.TaMapper;
import com.report.service.LectureService;
import com.report.service.StudentNoticeService;
import com.report.service.TaService;

@Controller
@RequestMapping("professor")
public class ProfessorController {

	@Autowired StudentMapper studentMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired private LectureService lectureService;
	@Autowired ProfessorLectureMapper professorLectureMapper;
	@Autowired StudentNoticeService studentNoticeService;
    @Autowired TaMapper taMapper;
    @Autowired DepartmentMapper departmentMapper;
    @Autowired private TaService taService;

      @RequestMapping("professorMain")
  	public String professorMain(Model model,Principal principal) {
    	  Professor professor = professorMapper.findByProfessorId(principal.getName());
      	  List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
      	  List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
      	  model.addAttribute("professorLecture1", professorLecture1);
      	  model.addAttribute("professorLecture2", professorLecture2);
          model.addAttribute("professor", professor);
  		return "professor/main"; // 로그인 한 교수를 위한 메인 페이지 URL
  	  }

      @RequestMapping("notice")
  	public String notice(Model model, Principal principal, @RequestParam("id") int id) {
    	Professor professor = professorMapper.findByProfessorId(principal.getName());
    	Lecture lecture = lectureMapper.findOne(id);
    	model.addAttribute("lecture", lecture);
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

      @RequestMapping("studentcontent")
   	public String studentcontent(Model model,Principal principal) {
     	Professor professor = professorMapper.findByProfessorId(principal.getName());
       	model.addAttribute("professor", professor);
   		return "professor/studentcontent"; // 학생 게시판 페이지
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


}