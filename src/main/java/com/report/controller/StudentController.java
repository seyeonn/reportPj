package com.report.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Lecture;
import com.report.dto.Student;
import com.report.mapper.StudentMapper;
import com.report.service.LectureService;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;
	@Autowired private LectureService lectureService;

    @RequestMapping("studentMain")
	public String studentMain(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	List<Lecture> studentlectures = studentMapper.findByStudentLecture(principal.getName());
    	List<Lecture> lectures = lectureService.findAll();
    	model.addAttribute("studentlectures",studentlectures);
		model.addAttribute("lectures", lectures);
    	model.addAttribute("student", student);
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL

	 }

    @RequestMapping("lecture")
 	public String studentlecture(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	List<Lecture> studentlectures = studentMapper.findByStudentLecture(principal.getName());
    	List<Lecture> lectures = lectureService.findAll();
    	model.addAttribute("studentlectures",studentlectures);
		model.addAttribute("lectures", lectures);
    	model.addAttribute("student", student);
 		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

 	 }


    @RequestMapping("notice")
  	public String notice(Model model) {
  		return "student/notice"; // 과제 및 공지 페이지

  	 }

    @RequestMapping("lecturefile")
  	public String lecturefile(Model model) {
  		return "student/lecturefile"; // 강의 자료 페이지

  	 }

    @RequestMapping("studentnotice")
  	public String studentnotice(Model model) {
  		return "student/studentnotice"; // 학생 게시판 페이지

  	 }

    @RequestMapping("studentposting")
   	public String studentposting(Model model) {
   		return "student/studentposting"; // 학생 게시판게시물 작성 페이

   	 }

    @RequestMapping("mypage")
   	public String mypage(Model model) {
   		return "student/mypage"; // 학생 게시판 페이지

   	 }

    @RequestMapping("information")
   	public String information(Model model) {
   		return "student/information"; // 학생 게시판 페이지

   	 }

}
