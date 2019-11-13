package com.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.dto.Department;
import com.report.dto.Professor;
import com.report.dto.Student;
import com.report.dto.User;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.TaMapper;
import com.report.mapper.UserMapper;

//아직 로그인 하지 않은 사용자를 위한 페이지를 구현한다.
@Controller
@RequestMapping("guest")
public class GuestController {

	@Autowired ProfessorMapper professorMapper;
	@Autowired TaMapper taMapper;
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired UserMapper userMapper;


	@RequestMapping({"/", "index"})
	public String index() {
		return "guest/index"; //로그인 하지 않은 사용자를 위한 첫 페이지 URL
	}

	@RequestMapping("login")
	public String login(Model model, HttpServletRequest request) {

		return "guest/login"; //로그인 페이지 UR
	}

	@RequestMapping("option")
	public static String option() {
		return "guest/option";
	}

	@RequestMapping("findpassword")
	public String findpassword(Model model) {

		return "guest/findpassword"; //비민번호 찾
	}

	//교수회원가입
	@Transactional
	@GetMapping(value="professorsignup")
	public String professorcreate(Model model) {
		Professor professor = new Professor();
		User user = new User();
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("professor", professor);
		model.addAttribute("departments", departments);
		user.setId(professor.getId());
		user.setPassword1(professor.getPassword1());
		user.setName(professor.getName());
		user.setEmail(professor.getProfessor_email());
		user.setUserType(professor.getUserType());
		user.setDepartment_no(professor.getDepartment_no());
		user.setPassword_question(professor.getPassword_question());
		user.setPassword_answer(professor.getPassword_answer());
		return "professor/signup";
	}

	@Transactional
	@PostMapping(value="professorsignup")
	public String professorcreate(Model model, Professor professor, User user) {
		professorMapper.insert(professor);
		userMapper.professorInsert(user);
		return "guest/login";
	}



	//학생회원가입
	@Transactional
	@GetMapping(value="studentsignup")
	public String studentcreate(Model model) {
		Student student = new Student();
		User user = new User();
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("student", student);
		model.addAttribute("departments", departments);
		user.setId(student.getId());
		user.setPassword1(student.getPassword1());
		user.setName(student.getName());
		user.setEmail(student.getStudent_email());
		user.setUserType(student.getUserType());
		user.setDepartment_no(student.getDepartment_no());
		user.setPassword_question(student.getPassword_question());
		user.setPassword_answer(student.getPassword_answer());
		return "student/signup";
	}


	@PostMapping(value="studentsignup")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String studentcreate(Model model, Student student, User user) {
		studentMapper.insert(student);
		userMapper.studentInsert(user);
		return "guest/login";
	}

}

