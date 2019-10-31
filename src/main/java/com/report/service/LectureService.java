package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dto.Lecture;
import com.report.mapper.LectureMapper;

@Service
public class LectureService {

    @Autowired
    public LectureMapper lectureMapper;

    public List<Lecture> findAll(){
        return lectureMapper.findAll();
    }

    public void deleteEntity(Lecture lecture) {
    	lectureMapper.delete(lecture);
    }


    public void save(LectureRegisterModel newLecture){
    	Lecture lecture = createLecture(newLecture);
    	lectureMapper.insert(lecture);
    }

    public Lecture createLecture(LectureRegisterModel newLecture){
        Lecture lecture = new Lecture();

        lecture.setLecture_name(newLecture.getLectureName());
        lecture.setLecture_type(newLecture.getLectureType());

        lecture.setTa_no((Integer) null);

        return lecture;

    }


}
