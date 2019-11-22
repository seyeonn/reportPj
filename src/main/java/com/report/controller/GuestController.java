package com.report.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.report.dto.Department;
import com.report.dto.Professor;
import com.report.dto.Student;
import com.report.dto.User;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.TaMapper;
import com.report.mapper.UserMapper;
import com.report.service.DepartmentService;
import com.report.service.UserService;

//아직 로그인 하지 않은 사용자를 위한 페이지를 구현한다.
@Controller
@RequestMapping("guest")
public class GuestController {

	@Autowired ProfessorMapper professorMapper;
	@Autowired TaMapper taMapper;
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired UserMapper userMapper;
	@Autowired UserService userService;
	@Autowired DepartmentService departmentService;
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

	@RequestMapping("newpassword")
	public String newpassword(Model model) {

		return "guest/newpassword"; //비민번호 찾
	}

	@RequestMapping("passwordquestion")
	public String passwordquestion(Model model) {

		return "guest/passwordquestion"; //비민번호 찾
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
		user.setPassword2(professor.getPassword2());
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
		user.setPassword2(student.getPassword2());
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
	public String studentcreate(Model model, Student student, User user, BindingResult bindingResult) {
		studentMapper.insert(student);
		userMapper.studentInsert(user);
//		if (userService.hasErrors(user, bindingResult)) {
//            model.addAttribute("departments", departmentService.findAll());
//            return "redirect:studentsignup";
//        }
		return "redirect:signupSuccess";
	}
	@RequestMapping("signupSuccess")
    public String registerSuccess() {
        return "guest/login";
    }
	
	// 회원 확인
	@ResponseBody
	@PostMapping(value = "idCheck")
	public int postIdCheck(HttpServletRequest req) throws Exception {
//	 logger.info("post idCheck");
	 
	 String id = req.getParameter("id");
	 
	 int result = 0;
	 
	 if(studentMapper.findByStudentId(id) != null) {
	  result = 1;
	 } 
	 
	 return result;
	}


}

