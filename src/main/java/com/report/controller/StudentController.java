package com.report.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Student;
import com.report.mapper.StudentMapper;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;

    @RequestMapping("studentMain")
	public String studentMain(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL

	 }
    @RequestMapping("lecture")
 	public String studentlecture(Model model) {
 		return "student/lecture"; // 강의 추가 페이

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
