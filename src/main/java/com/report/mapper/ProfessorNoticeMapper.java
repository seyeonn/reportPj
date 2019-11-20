package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	int count(int lecture_no);
}
