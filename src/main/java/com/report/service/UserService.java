package com.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dto.User;
import com.report.mapper.UserMapper;

@Service
public class UserService {

	@Autowired UserMapper userMapper;

	public User login(String loginId, String password) {
		User user = userMapper.findByLoginId(loginId);
		if(user == null) {
			return null;
		}
		String pw = password;
		if(!user.getPassword1().equals(pw)) {
			return null;
		}
		return user;
	}
}
