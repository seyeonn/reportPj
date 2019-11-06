package com.report.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import com.report.service.StudentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;
import com.report.dto.Student;
import com.report.dto.StudentLecture;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentLectureMapper;
import com.report.mapper.StudentMapper;
import com.report.service.LectureService;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired private LectureService lectureService;
	@Autowired ProfessorLectureMapper professorLectureMapper;
	@Autowired StudentLectureMapper studentLectureMapper;
	@Autowired StudentNoticeService studentNoticeService;

	@RequestMapping("studentMain")
	public String studentMain(Model model, Principal principal) {
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("student", student);
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL

	}

	@RequestMapping(value="lecture", method=RequestMethod.GET)
	public String studentlecture(Model model, Lecture lecture, Principal principal) {
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("lectures", lectures);
		
		model.addAttribute("studentLecture", new StudentLecture());
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}

	@RequestMapping(value="lecture", method=RequestMethod.POST, params="cmd=delete")
	public String studentlecture1(Model model, @RequestParam("id") int id, Principal principal, Lecture lecture, StudentLecture studentLecture) {
		System.out.printf("%d\n", id);
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("lectures", lectures);
		model.addAttribute("student", student);
		model.addAttribute("studentLecture", studentLecture);
		
		lectureService.studentLectureDelete(id, student.getStudent_no());
		
		System.out.printf("%s, %s\n", student.getName(), lecture.getLecture_name());
		return "redirect:lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}
	
	@RequestMapping(value="lecture", method=RequestMethod.POST, params="cmd=insert")
	public String studentlecture2(Model model, @RequestParam("id") int id, Principal principal, Lecture lecture, StudentLecture studentLecture) {
		System.out.printf("%d\n", id);
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("lectures", lectures);
		model.addAttribute("student", student);
		model.addAttribute("studentLecture", studentLecture);
		
		lectureService.studentSave(id, student.getStudent_no());
		
		System.out.printf("%s, %s\n", student.getName(), lecture.getLecture_name());
		return "redirect:lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}


    @RequestMapping("notice")
  	public String notice(Model model, Principal principal, @RequestParam("id") int id) {
    	Lecture lecture = lectureMapper.findOne(id);
    	ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
    	Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
    	model.addAttribute("lecture", lecture);
    	model.addAttribute("professor", professor);
  		return "student/notice"; // 과제 및 공지 페이지
	}

	@RequestMapping("studentnotice")
	public String list(Model model, Principal principal, @RequestParam("id") int id) {
		Lecture lecture = lectureMapper.findOne(id);
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		return "student/studentnotice";
	}

	@RequestMapping("lecturefile")
	public String lecturefile(Model model) {
		return "student/lecturefile"; // 강의 자료 페이지

	}


	@RequestMapping("mypage")
	public String mypage(Model model) {
		return "student/mypage"; // 학생 게시판 페이지

	}

	@RequestMapping("information")
	public String information(Model model) {
		return "student/information"; // 학생 게시판 페이지

	}

    @RequestMapping("noticecontent")
   	public String noticecontent(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/noticecontent"; // 학생 게시판 페이지
    }

    @RequestMapping("worksubmit")
   	public String worksubmit(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/worksubmit"; // 학생 게시판 페이지
    }
}
