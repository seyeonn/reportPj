package com.report.mapper;

import java.util.List;

import com.report.dto.Student;
import org.apache.ibatis.annotations.Mapper;

import com.report.dto.User;

@Mapper
public interface UserMapper {
	User findOne(int no);
	User findByLoginId(String id);
	List<User> findAll();
	void studentInsert(User user);
	void professorInsert(User user);
	void taInsert(User user);
	void update(User user);
	void delete(int no);
	void changeType(String id);
}
