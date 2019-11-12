package com.report.controller;

import java.security.Principal;
import java.util.List;

import com.report.dto.*;
import com.report.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.report.service.LectureService;
import com.report.service.StudentNoticeService;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired LectureService lectureService;
	@Autowired ProfessorLectureMapper professorLectureMapper;
	@Autowired StudentLectureMapper studentLectureMapper;
	@Autowired StudentNoticeService studentNoticeService;
	@Autowired ProfessorNoticeMapper professorNoticeMapper;
	@Autowired
	StudentNoticeMapper studentNoticeMapper;

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
		List<ProfessorNotice>  professorNotices = professorNoticeMapper.list(id);
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("professorNotices", professorNotices);
		return "student/notice"; // 과제 및 공지 페이지
	}

	@RequestMapping("studentnotice")
	public String list(Model model, Principal principal, @RequestParam("id") int id){
		List<StudentNotice> studentNotices = studentNoticeService.list(id);
		Student student = studentMapper.findByStudentId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);

		model.addAttribute("studentNotices", studentNotices);
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		//System.out.println(lecture.getLecture_name());

		return "student/studentnotice";
	}//학생 게시판 목록

	@GetMapping("studentcontent")
	public String studentContent(Model model, Principal principal, @RequestParam("id") int id){
		Student student = studentMapper.findByStudentId(principal.getName());
		StudentNotice studentNotice = studentNoticeService.findOne(id);
		Lecture lecture = lectureMapper.findOne(studentNotice.getLecture_no());

		model.addAttribute("lecture", lecture);
		model.addAttribute("student", student);
		model.addAttribute("studentNotice", studentNotice);

		//System.out.println(lecture.getLecture_name());
		return "student/studentcontent";
	}//게시글 조회

	@GetMapping("studentposting")
	public String studentPosting(Model model, Principal principal, @RequestParam("id") int id){
		studentNoticeService.insert(model, id, principal);
		return "student/studentposting";
	}//게시글 작성


	@PostMapping("studentposting")
	public String studentPosting(Model model, Principal principal, @RequestParam("id") int id, StudentNotice newStudentNotice){
		studentNoticeService.insert(model, principal, newStudentNotice, id);
		return "redirect:studentnotice?id=" + id;
	}//게시글 작성

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("studentnotice_no") int studentnotice_no){
		studentNoticeService.delete(model, studentnotice_no);
		return "student/studentnotice";
	}//게시판 글 삭제



	@RequestMapping("lecturefile")
	public String lecturefile(Model model, Principal principal, @RequestParam("id") int id) {
		Lecture lecture = lectureMapper.findOne(id);
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
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

	@GetMapping("noticecontent")
	public String noticecontent(Model model, Principal principal, @RequestParam("id") int id) {
		Student student = studentMapper.findByStudentId(principal.getName());
		ProfessorNotice professorNoice = professorNoticeMapper.findOne(id);
		Lecture lecture = lectureMapper.findOne(professorNoice.getLecture_no());
		model.addAttribute("lecture", lecture);
		model.addAttribute("professorNotice", professorNoice);
		model.addAttribute("student", student);
		return "student/noticecontent"; // 과제 및 공지 내용 페이지
	}

	@RequestMapping("worksubmit")
	public String worksubmit(Model model, Principal principal) {
		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		return "student/worksubmit"; // 학생 게시판 페이지
	}
}