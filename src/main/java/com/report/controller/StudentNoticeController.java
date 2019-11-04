package com.report.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;
import com.report.dto.Student;
import com.report.dto.StudentNotice;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentMapper;
import com.report.service.LectureService;
import com.report.service.StudentNoticeService;

@Controller
@RequestMapping("student")
public class StudentNoticeController {
    @Autowired
    StudentNoticeService studentNoticeService;
	@Autowired StudentMapper studentMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired private LectureService lectureService;
	@Autowired ProfessorLectureMapper professorLectureMapper;


    @GetMapping("studentnotice")
    public String list(Model model, Principal principal, @RequestParam("id") int id) {
    	Lecture lecture = lectureMapper.findOne(id);
    	ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
    	Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
    	model.addAttribute("lecture", lecture);
    	model.addAttribute("professor", professor);
        model.addAttribute("list", studentNoticeService.list(id));
        return "student/studentnotice";
    }

    @GetMapping("studentposting")
    public String createNotice(Model model,
                               @RequestParam("id") int id,
                               Principal principal){
        //studentNoticeService.insert(model, id, principal);
        return "student/studentposting";
    }


    @PostMapping("studentposting")
    public String createNotice(Model model, StudentNotice newStudentNotice){
        studentNoticeService.insert(model, newStudentNotice);
        return "student/studentnotice";
    }

    @RequestMapping("delete")
    public String delete(Model model,
                         @RequestParam("studentnotice_no")int studentnotice_no){
        studentNoticeService.delete(model, studentnotice_no);
        return "student/studentnotice";
    }

//    @RequestMapping("delete")
//    public String delete(Model model,
//                         @RequestParam("studentnotice_no") int studentnotice_no){
//        studentNoticeService.delete(model, studentnotice_no);
//        return "student/studentnotice";
//    }

    @PostMapping("update")
    public String update(Model model, StudentNotice newStudentNotice){
        studentNoticeService.update(model, newStudentNotice);
        return "redirect:studentnotice";
    }


    @RequestMapping("studentcontent")
   	public String studentcontent(Model model, Principal principal) {
    	Student student = studentMapper.findByStudentId(principal.getName());
    	model.addAttribute("student", student);
   		return "student/studentcontent"; // 학생 게시판 페이지


    }


}