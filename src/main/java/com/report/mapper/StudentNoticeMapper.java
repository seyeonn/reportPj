package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.report.dto.StudentNotice;
import com.report.model.Pagination;

@Mapper
public interface StudentNoticeMapper {

    List<StudentNotice> list(int lecture_no);


    StudentNotice findOne(int studentnotice_no);

    public void insert(StudentNotice studentNotice);

    public void update(StudentNotice studentNotice);

    public void delete(int studentnotice_no);


    List<StudentNotice> listWithStudentName(@Param("lecture_no") int lecture_no, @Param("pagination") Pagination pagination);
    int count(int lecture_no);
}