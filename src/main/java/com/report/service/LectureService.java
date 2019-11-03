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


    public void save(Lecture newLecture){
    	Lecture lecture = createLecture(newLecture);
    	lectureMapper.insert(lecture);
    }

    public Lecture createLecture(Lecture newLecture){
        Lecture lecture = new Lecture();

        lecture.setLecture_name(newLecture.getLecture_name());
        lecture.setLecture_type(newLecture.getLecture_type());

        lecture.setTa_no(newLecture.getTa_no());

        return lecture;

    }


}
