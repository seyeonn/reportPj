package com.report.service;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorNotice;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.ProfessorNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Service
public class ProfessorNoticeService {
    @Autowired
    ProfessorNoticeMapper professorNoticeMapper;
    @Autowired
    ProfessorMapper professorMapper;
    @Autowired
    LectureMapper lectureMapper;

    public List<ProfessorNotice> list(int lecture_no) {
        return professorNoticeMapper.list(lecture_no);
    }

    //get
    public void insert(Model model,
                       int lecture_no,
                       Principal principal) {
        ProfessorNotice professorNotice = new ProfessorNotice();
        Lecture lecture = lectureMapper.findOne(lecture_no);
        Professor professor = professorMapper.findByProfessorId(principal.getName());

        model.addAttribute("lecture", lecture);
        model.addAttribute("professor", professor);
    }

    //POST
    public void insert(Model model, ProfessorNotice newProfessorNotice) {
        professorNoticeMapper.insert(newProfessorNotice);
    }

    //GET
    public void update(Model model,
                       int notice_no,
                       int lecture_no,
                       Principal principal) {
        ProfessorNotice professorNotice = professorNoticeMapper.findOne(notice_no);
        Professor professor = professorMapper.findByProfessorId(principal.getName());
        Lecture lecture = lectureMapper.findOne(lecture_no);

        model.addAttribute("professorNotice", professorNotice);
        model.addAttribute("professor", professor);
        model.addAttribute("lecture", lecture);
    }

    //POST
    public void update(Model model, ProfessorNotice newProfessorNotice) {
        professorNoticeMapper.update(newProfessorNotice);
    }

    public void delete(Model model, int notice_no) {
        professorNoticeMapper.delete(notice_no);
    }
}