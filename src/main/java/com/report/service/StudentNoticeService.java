package com.report.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.report.dto.Lecture;
import com.report.dto.Student;
import com.report.dto.StudentNotice;
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

    public List<StudentNotice> listWithStudentName(int id){
        return studentNoticeMapper.listWithStudentName(id);
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
    public void update(StudentNotice newStudentNotice) {
        studentNoticeMapper.update(newStudentNotice);
    }


    public void delete(int studentnotice_no) {
        studentNoticeMapper.delete(studentnotice_no);
    }


}