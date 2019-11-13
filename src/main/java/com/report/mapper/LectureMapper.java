package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.Lecture;

@Mapper
public interface LectureMapper {

	Lecture findOne(int lecture_no);

	Lecture findByLectureName(String lecture_name);

	Lecture findStudentByLectureNo(int lecture_no);

	List<Lecture> findAll();

	void insert(Lecture lecture);

	void update(Lecture lecture);
	void delete(int lecture_no);

	void taLectureYesUpdate(int ta_no, int lecture_no);
	void taLectureNoUpdate(int lecture_no);

	List<Lecture> findByTaLecture(int ta_no);

	List<Lecture> findA(int studnet_no);
	Lecture findO(int lecture_no);

}
