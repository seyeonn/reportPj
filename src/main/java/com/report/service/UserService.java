package com.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.report.dto.Professor;
import com.report.dto.Student;
import com.report.dto.User;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.UserMapper;

@Service
public class UserService {

	@Autowired UserMapper userMapper;
	@Autowired StudentMapper studentMapper;

	@Autowired ProfessorMapper professorMapper;

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
	public boolean hasErrors(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return true;
//        if (userModel.getPasswd1().equals(userModel.getPasswd2()) == false) {
//            bindingResult.rejectValue("passwd2", null, "비밀번호가 일치하지 않습니다.");
//            return true;
////        }
//        Student student1 = studentMapper.findByStudentId(user.getId());
        if (userMapper.findByLoginId(user.getId()) != null) {
            bindingResult.rejectValue("id", null, "사용자 아이디가 중복됩니다.");
            return true;
        }
        return false;
    }
	public Boolean findPassword(String loginId, String name, String email) {
		try {
	      User user = userMapper.findByLoginId(loginId);

	      if(user.getName().equals(name) && user.getEmail().equals(email)) {
	            user.setPassword1("s"+loginId);
	            user.setPassword2("s"+loginId);
	            userMapper.update(user);

	            if(user.getUserType().equals("학생")) {
	            	Student student = studentMapper.findByStudentId(user.getId());
	    	  		student.setPassword1(user.getPassword1());
	    	  		student.setPassword2(user.getPassword2());
	    	  		studentMapper.update(student);
	            }else if(user.getUserType().equals("교수")) {
		  			Professor professor = professorMapper.findByProfessorId(user.getId());
		  			professor.setPassword1(user.getPassword1());
		  			professor.setPassword2(user.getPassword2());
		  			professorMapper.update(professor);
	            }
	            return true;
	        }

	      return false;
		}
		catch(NullPointerException e) {
			return false;
		}
	   }

}
