package com.report.service;

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

    public List<StudentNotice> list( int lecture_no) {
        return studentNoticeMapper.list(lecture_no);
    }

    //get
    public void insert(Model model,
                       int lecture_no,
                        int student_no) {
        StudentNotice studentNotice = new StudentNotice();
        Lecture lecture = lectureMapper.findOne(lecture_no);
        Student student = studentMapper.findOne(student_no);

        model.addAttribute("lecture", lecture);
        model.addAttribute("student", student);
    }

    //post
    public void insert(Model model, StudentNotice newStudentNotice) {
        studentNoticeMapper.insert(newStudentNotice);
    }

    //get
    public void update(Model model,
                       int no,
                       int student_no,
                       int lecture_no) {

        StudentNotice studentNotice = studentNoticeMapper.findOne(no);

        Student student = studentMapper.findOne(student_no);

        Lecture lecture = lectureMapper.findOne(lecture_no);

        model.addAttribute("studentNotice", studentNotice);
        model.addAttribute("student", student);
        model.addAttribute("lecture", lecture);

    }

    //post
    public void update(Model model, StudentNotice newStudentNotice) {
        studentNoticeMapper.update(newStudentNotice);
    }


    public void delete(Model model, int no) {
        studentNoticeMapper.delete(no);
    }
}