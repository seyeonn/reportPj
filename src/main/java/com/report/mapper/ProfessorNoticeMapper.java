package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.ProfessorNotice;

@Mapper
public interface ProfessorNoticeMapper {
	List<ProfessorNotice> list(int lecture_no);

    ProfessorNotice findOne(int notice_no);
    ProfessorNotice findByOne(String title);
    
    public void insert(ProfessorNotice professorNotice);

    public void update(ProfessorNotice professorNotice);

    public void delete(int notice_no);
}
