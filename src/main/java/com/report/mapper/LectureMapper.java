package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.report.dto.Lecture;
import com.report.model.Pagination;

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

	List<Lecture> findA(@Param("student_no") int student_no, @Param("pagination") Pagination pagination);
	List<Lecture> findSearch(@Param("student_no") int student_no, @Param("pagination") Pagination pagination, String search);
	int countSearch(@Param("student_no") int student_no, String search);
	Lecture findO(int lecture_no);
	int count(int studnet_no);

	List<Lecture> search(String name);


}
