package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dto.Lecture;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;
import com.report.dto.Student;
import com.report.dto.StudentLecture;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.StudentLectureMapper;

@Service
public class LectureService {

    @Autowired
    public LectureMapper lectureMapper;

    @Autowired
    public ProfessorLectureMapper professorLectureMapper;

    @Autowired
    public StudentLectureMapper studentLectureMapper;

    public List<Lecture> findAll(){
        return lectureMapper.findAll();
    }

    public void deleteEntity(int id) {
    	lectureMapper.delete(id);
    }

    public void studentLectureDelete(int id, int student_no) {
    	studentLectureMapper.delete(id, student_no);
    }

    public void professorSave(Lecture newLecture, ProfessorLecture professorLecture, Professor professor){
    	Lecture lecture = createLecture(newLecture);
    	lectureMapper.insert(lecture);
    	professorLecture.setLecture_no(lecture.getLecture_no());
		professorLecture.setProfessor_no(professor.getProfessor_no());
    	professorLectureMapper.insert(professorLecture);
    }


    public void studentSave(int lecture_no, int student_no){
    	StudentLecture studentLecture = new StudentLecture();
    	studentLecture.setLecture_no(lecture_no);
    	studentLecture.setStudent_no(student_no);
    	studentLectureMapper.insert(studentLecture);
    }


    public Lecture createLecture(Lecture newLecture){
        Lecture lecture = new Lecture();

        lecture.setLecture_name(newLecture.getLecture_name());
        lecture.setLecture_type(newLecture.getLecture_type());

        lecture.setTa_no(newLecture.getTa_no());

        return lecture;
    }
    
    public void taNoLecture(int lecture_no) {
    	lectureMapper.taLectureNoUpdate(lecture_no);
    }
    
    public void taYesLecture(int ta_no, int lecture_no) {
    	lectureMapper.taLectureYesUpdate(ta_no, lecture_no);
    }


}
