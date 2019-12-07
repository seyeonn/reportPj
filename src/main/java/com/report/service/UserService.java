package com.report.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

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

	@Autowired
	UserMapper userMapper;
	@Autowired
	StudentMapper studentMapper;

	@Autowired
	ProfessorMapper professorMapper;

	public User login(String loginId, String password) {
		User user = userMapper.findByLoginId(loginId);
		if (user == null) {
			return null;
		}
		String pw = password;
		if (!user.getPassword1().equals(pw)) {
			return null;
		}
		return user;
	}

	public boolean hasErrorsInStudent(Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return true;
		}
		Student student1 =studentMapper.findByStudentId(student.getId());
		if(student1!=null) {
			bindingResult.rejectValue("id", null, "이미 존재하는 ID입니다.");
			System.out.println("실행되니?");
			return true;
		}
		return false;
	}
	public boolean hasErrorsInProfessor(Professor professor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return true;
		}
		Professor professor1 =professorMapper.findByProfessorId(professor.getId());
		if(professor1!=null) {
			bindingResult.rejectValue("id", null, "이미 존재하는 ID입니다.");
			return true;
		}
		return false;
	}

	public Boolean findPassword(String loginId, String name, String email, HttpServletResponse response) throws IOException {
		try {
		User user = userMapper.findByLoginId(loginId);

		if (user.getName().equals(name) && user.getEmail().equals(email)) {
			user.setPassword1("s" + loginId);
			user.setPassword2("s" + loginId);
			userMapper.update(user);

			if (user.getUserType().equals("학생")) {
				Student student = studentMapper.findByStudentId(user.getId());
				student.setPassword1(user.getPassword1());
				student.setPassword2(user.getPassword2());
				studentMapper.update(student);
			} else if (user.getUserType().equals("교수")) {
				Professor professor = professorMapper.findByProfessorId(user.getId());
				professor.setPassword1(user.getPassword1());
				professor.setPassword2(user.getPassword2());
				professorMapper.update(professor);
			}
			return true;
		}

		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('이름이나 이메일이 일치하지 않습니다.'); history.go(-1);</script>");
        out.flush();
	      return false;
		}
		catch(NullPointerException e) {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('아이디를 다시 확인해주세요.'); history.go(-1);</script>");
            out.flush();
			return false;
		}
	}

}
