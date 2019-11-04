package com.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.dto.StudentNotice;
import com.report.service.StudentNoticeService;

@Controller
@RequestMapping("student")
public class StudentNoticeController {
    @Autowired
    StudentNoticeService studentNoticeService;


    @GetMapping("studentnotice")
    public String list(Model model,
                       @RequestParam("lecture_no") int lecture_no){
        model.addAttribute("list", studentNoticeService.list(lecture_no));
        return "student/studentnotice";
    }

    @GetMapping("studentposting")
    public String createNotice(Model model,
                               @RequestParam("lecture_no") int lecture_no,
                               @RequestParam("student_no") int student_no){
        studentNoticeService.insert(model, lecture_no, student_no);
        return "student/studentposting";
    }

    @PostMapping("studentposting")
    public String createNotice(Model model, StudentNotice newStudentNotice){
        studentNoticeService.insert(model, newStudentNotice);
        return "redirect:studentnotice";
    }

    @RequestMapping("delete")
    public String delete(Model model,
                         @RequestParam("studentnotice_no")int studentnotice_no){
        studentNoticeService.delete(model, studentnotice_no);
        return "student/studentnotice";
    }

    @PostMapping("update")
    public String update(Model model, StudentNotice newStudentNotice){
        studentNoticeService.update(model, newStudentNotice);
        return "redirect:studentnotice";
    }

    @GetMapping("update")
    public String update(Model model,
                         @RequestParam("studentnotice_no")int studentnotice_no,
                         @RequestParam("student_no") int student_no,
                         @RequestParam("lecture_no") int lecture_no){
        studentNoticeService.update(model, studentnotice_no, student_no, lecture_no);
        return "student/update";
    }


}