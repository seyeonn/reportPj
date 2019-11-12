package com.report.service;

import java.security.Principal;
import java.util.List;

import com.report.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.report.mapper.LectureMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.StudentNoticeMapper;

@Service
public class StudentNoticeService {
    @Autowired
    StudentNoticeMapper studentNoticeMapper;

    @Autowired
    LectureMapper lectureMapper;

    @Autowired
    StudentMapper studentMapper;

    public List<StudentNotice> list(int id) {
        return studentNoticeMapper.list(id);
    }

    public StudentNotice findOne(int studentnotice_no){
        return studentNoticeMapper.findOne(studentnotice_no);
    }

    //get
    public void insert(Model model, int id, Principal principal) {
        StudentNotice studentNotice = new StudentNotice();
        Lecture lecture = lectureMapper.findOne(id);
        Student student = studentMapper.findByStudentId(principal.getName());

        System.out.println(lecture.getLecture_name());

        model.addAttribute("studentNotice", studentNotice);
        model.addAttribute("lecture", lecture);
        model.addAttribute("student", student);

    }
    //post
    public void insert(Model model, Principal principal, StudentNotice newStudentNotice, int id) {
        Student student = studentMapper.findByStudentId(principal.getName());
        Lecture lecture = lectureMapper.findOne(id);

        System.out.println(lecture.getLecture_name());

        newStudentNotice.setLecture_no(id);
        newStudentNotice.setStudent_no(student.getStudent_no());

        model.addAttribute("student", student);
        model.addAttribute("lecture", lecture);

        studentNoticeMapper.insert(newStudentNotice);

    }

    //get
    public void update(Model model, int no, Principal principal, int lecture_no) {

        StudentNotice studentNotice = studentNoticeMapper.findOne(no);

        Student student = studentMapper.findByStudentId(principal.getName());

        Lecture lecture = lectureMapper.findOne(lecture_no);

        model.addAttribute("studentNotice", studentNotice);
        model.addAttribute("student", student);
        model.addAttribute("lecture", lecture);
    }

    //post
    public void update(Model model, StudentNotice newStudentNotice) {
        studentNoticeMapper.update(newStudentNotice);
    }


    public void delete(Model model, int studentnotice_no) {
        studentNoticeMapper.delete(studentnotice_no);
    }


}