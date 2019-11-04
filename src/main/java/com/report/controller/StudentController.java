package com.report.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Lecture;
import com.report.dto.Student;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentMapper;
import com.report.service.LectureService;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired private LectureService lectureService;

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

    @RequestMapping("lecture")
 	public String studentlecture(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
    	List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
    	List<Lecture> lectures = lectureService.findAll();
    	model.addAttribute("studentlectures1",studentlectures1);
    	model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("lectures", lectures);
    	model.addAttribute("student", student);
 		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

 	 }


    @RequestMapping("notice")
  	public String notice(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
  		return "student/notice"; // 과제 및 공지 페이지

  	 }

    @RequestMapping("lecturefile")
  	public String lecturefile(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
  		return "student/lecturefile"; // 강의 자료 페이지

  	 }

    @RequestMapping("studentnotice")
  	public String studentnotice(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
  		return "student/studentnotice"; // 학생 게시판 페이지

  	 }

    @RequestMapping("studentposting")
   	public String studentposting(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/studentposting"; // 학생 게시판게시물 작성 페이

   	 }

    @RequestMapping("mypage")
   	public String mypage(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/mypage"; // 학생 게시판 페이지

   	 }

    @RequestMapping("information")
   	public String information(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/information"; // 학생 게시판 페이지

   	 }

    @RequestMapping("noticecontent")
   	public String noticecontent(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/noticecontent"; // 학생 게시판 페이지

   	 }

    @RequestMapping("studentcontent")
   	public String studentcontent(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/studentcontent"; // 학생 게시판 페이지

   	 }
}
