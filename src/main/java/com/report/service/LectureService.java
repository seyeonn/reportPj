package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;

@Service
public class LectureService {

    @Autowired
    public LectureMapper lectureMapper;
    
    @Autowired
    public ProfessorLectureMapper professorLectureMapper;

    public List<Lecture> findAll(){
        return lectureMapper.findAll();
    }

    public void deleteEntity(Lecture lecture) {
    	lectureMapper.delete(lecture);
    }


    public void save(Lecture newLecture, ProfessorLecture professorLecture, Professor professor){
    	Lecture lecture = createLecture(newLecture);
    	lectureMapper.insert(lecture);
    	professorLecture.setLecture_no(lecture.getLecture_no());
		professorLecture.setProfessor_no(professor.getProfessor_no());
    	professorLectureMapper.insert(professorLecture);
    }

    public Lecture createLecture(Lecture newLecture){
        Lecture lecture = new Lecture();

        lecture.setLecture_name(newLecture.getLecture_name());
        lecture.setLecture_type(newLecture.getLecture_type());

        lecture.setTa_no(newLecture.getTa_no());

        return lecture;

    }


}
