package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.StudentNotice;

@Mapper
public interface StudentNoticeMapper {

    List<StudentNotice> list(int lecture_no);

    List<StudentNotice> listWithStudentName(int lecture_no);

    StudentNotice findOne(int studentnotice_no);

    public void insert(StudentNotice studentNotice);

    public void update(StudentNotice studentNotice);

    public void delete(int studentnotice_no);

}