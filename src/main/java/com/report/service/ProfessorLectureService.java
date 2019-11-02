package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dto.Lecture;
import com.report.dto.ProfessorLecture;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;

@Service
public class ProfessorLectureService {

	@Autowired
	ProfessorLectureMapper professorLectureMapper;

	@Autowired
	LectureMapper lectureMapper;


	public List<ProfessorLecture> SelectLecture(int no){
		Lecture lecture = lectureMapper.findOne(no);
		return lecture.getProfessorLectureList();
	}
}
