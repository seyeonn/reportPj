package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Lecture;
import com.report.dto.Student;

@Mapper
public interface StudentMapper {
    Student findOne(int student_no);
    Student findByStudentId(String student_id);
    List<Lecture>  findByStudentLecture1(String student_id);
    List<Lecture>  findByStudentLecture2(String student_id);
    List<Student> findAll();
    void insert(Student student);
    void update(Student student);
    void delete(int student_no);
}

