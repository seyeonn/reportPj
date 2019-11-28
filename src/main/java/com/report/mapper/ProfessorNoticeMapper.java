package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.report.dto.Homework;
import com.report.dto.ProfessorNotice;
import com.report.model.Pagination;

@Mapper
public interface ProfessorNoticeMapper {

    ProfessorNotice findOne(int notice_no);
    ProfessorNotice findByOne(String title);

    public void insert(ProfessorNotice professorNotice);

    public void update(ProfessorNotice professorNotice);

    public void delete(int notice_no);

    List<ProfessorNotice> list(@Param("lecture_no") int lecture_no, @Param("pagination") Pagination pagination);

    //학생들이 교수님이 입력한 점수 볼 수 있도록 student/notice 부분 의 jsp 수정을 위해 변경
    List<ProfessorNotice> studentlist(@Param("lecture_no") int lecture_no, @Param("pagination") Pagination pagination, @Param("student_no")int student_no);


	int count(int lecture_no);
}
