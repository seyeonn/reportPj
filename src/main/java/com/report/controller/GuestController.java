package com.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	@GetMapping("findpassword")
	public String findpassword(Model model, User user) {
		User users = userMapper.findByLoginId(user.getId());

		return "guest/findpassword";
	}

	 @PostMapping("findpassword")
	   public String findpassword2(Model model, User user, HttpServletResponse response)throws IOException {

//	      User users = userMapper.findByLoginId(user.getId());
	//
//	      if(user.getId() == null) {
//	         return null;
//	      }
//	      String gname = user.getName();
//	      if(!users.getName().equals(gname)) {
//	         return null;
//	      }
//	      String gemail = user.getEmail();
//	      if(!users.getEmail().equals(gemail)) {
//	         return null;
//	      }
	      if(userService.findPassword(user.getId(), user.getName(), user.getEmail(), response)) {
	            model.addAttribute("findError", false);
	            model.addAttribute("loginError", false);
	            return "guest/login";
	        }else {
	            model.addAttribute("findError", true);
	            model.addAttribute("loginError", false);
	            return null;
	        }

	       //비민번호 찾

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
	public String professorcreate(Model model, User user,@Valid Professor professor, BindingResult bindingResult) {
		if (userService.hasErrorsInProfessor(professor, bindingResult)) {
            model.addAttribute("departments", departmentService.findAll());
            return "professor/signup";
        }
		user.setEmail(professor.getProfessor_email());
		professorMapper.insert(professor);
		userMapper.professorInsert(user);
		return "redirect:signupSuccess";
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
	public String studentcreate(Model model, User user,@Valid Student student, BindingResult bindingResult) {
//		studentMapper.insert(student);
//		userMapper.studentInsert(user);
		if (userService.hasErrorsInStudent(student, bindingResult)) {
            model.addAttribute("departments", departmentService.findAll());
            System.out.println("나와라");
            return "student/signup";
        }
		user.setEmail(student.getStudent_email());
		studentMapper.insert(student);
		userMapper.studentInsert(user);
		System.out.println("나왔냐");
		return "redirect:signupSuccess";
	}
	@RequestMapping("signupSuccess")
	public String registerSuccess() {
		return "guest/login";
	}



}

