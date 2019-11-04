package com.report.mapper;

import com.report.dto.ProfessorNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorNoticeMapper {
    List<ProfessorNotice> list(int lecture_no);

    ProfessorNotice findOne(int notice_no);

    public void insert(ProfessorNotice professorNotice);

    public void update(ProfessorNotice professorNotice);

    public void delete(int notice_no);
}
