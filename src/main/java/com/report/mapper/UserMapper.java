package com.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.report.dto.User;

@Mapper
public interface UserMapper {
	User findOne(int no);
	User findByLoginId(String loginId);
	List<User> findAll();
	void insert(User user);
	void update(User user);
	void delete(int no);
}
