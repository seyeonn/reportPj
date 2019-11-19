package com.report.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.report.dto.*;
import com.report.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.report.dto.Homework;
import com.report.dto.Lecture;
import com.report.dto.Lecturefile;
import com.report.dto.Professor;
import com.report.dto.ProfessorNotice;
import com.report.dto.StudentNotice;
import com.report.dto.Ta;
import com.report.dto.User;
import com.report.mapper.DepartmentMapper;
import com.report.mapper.HomeworkMapper;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.ProfessorNoticeMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.StudentNoticeMapper;
import com.report.mapper.TaMapper;
import com.report.mapper.UserMapper;
import com.report.service.LectureService;
import com.report.service.LecturefileService;
import com.report.service.StudentNoticeService;
import com.report.service.TaService;

@Controller
@RequestMapping("professor")
public class ProfessorController {

	@Autowired StudentMapper studentMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired private LectureService lectureService;
	@Autowired ProfessorLectureMapper professorLectureMapper;
	@Autowired StudentNoticeService studentNoticeService;
	@Autowired TaMapper taMapper;
	@Autowired DepartmentMapper departmentMapper;
	@Autowired private TaService taService;
	@Autowired HomeworkMapper homeworkMapper;
	@Autowired LecturefileService lecturefileService;
	@Autowired UserMapper userMapper;
	@Autowired StudentNoticeMapper studentNoticeMapper;
	@Autowired ProfessorNoticeMapper professorNoticeMapper;

	@RequestMapping("professorMain")
	public String professorMain(Model model,Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> professorLecture1 = professorMapper.findByProfessorLecture1(principal.getName());
		List<Lecture> professorLecture2 = professorMapper.findByProfessorLecture2(principal.getName());
		model.addAttribute("professorLecture1", professorLecture1);
		model.addAttribute("professorLecture2", professorLecture2);
		model.addAttribute("professor", professor);
		return "professor/main"; // 로그인 한 교수를 위한 메인 페이지 URL
	}

	@RequestMapping("notice")
	public String notice(Model model, Principal principal, @RequestParam("id") int id) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		List<ProfessorNotice>  professorNotices = professorNoticeMapper.list(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("professorNotices", professorNotices);
		return "professor/notice"; // 과제 및 공지 페이지
	}

	@GetMapping("posting")
	public String posting(Model model,Principal principal, @RequestParam("id") int id) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("professorNotice", new ProfessorNotice());
		return "professor/posting"; // 과제 및 공지 작성 페이지
	}

	@PostMapping("posting")
	public String posting(Model model,Principal principal, @RequestParam("id") int id, ProfessorNotice professorNotice) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("professor", professor);
		Lecture lecture = lectureMapper.findOne(id);
		model.addAttribute("lecture", lecture);
		professorNotice.setLecture_no(id);
		professorNotice.setProfessor_no(professor.getProfessor_no());
		professorNoticeMapper.insert(professorNotice);
		return "redirect:notice?id="+id; // 과제 및 공지 작성 페이지
	}

	@GetMapping("noticecontent")
	public String noticecontent(Model model,Principal principal, @RequestParam("id") int id) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		ProfessorNotice professorNoice = professorNoticeMapper.findOne(id);
		Lecture lecture = lectureMapper.findOne(professorNoice.getLecture_no());
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("professorNotice", professorNoice);
		return "professor/noticecontent"; // 과제 및 공지 작성 페이지
	}

	@PostMapping(value = "noticecontent", params="cmd=delete")
	public String noticecontentdelete(Model model,Principal principal, @RequestParam("notice_no") int notice_no,@RequestParam("lecture_no") int lecture_no) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("professor", professor);
		Lecture lecture = lectureMapper.findOne(lecture_no);
		model.addAttribute("lecture", lecture);
		professorNoticeMapper.delete(notice_no);
		System.out.println(lecture_no);
		System.out.print(notice_no);
		return "redirect:notice?id="+lecture_no; // 과제 및 공지 작성 페이지
	}

	@GetMapping("noticecontentedit")
	public String noticecontentedit1(Model model,Principal principal, @RequestParam("notice_no") int notice_no,@RequestParam("lecture_no") int lecture_no) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("professor", professor);
		Lecture lecture = lectureMapper.findOne(lecture_no);
		model.addAttribute("lecture", lecture);
		ProfessorNotice professorNoice = professorNoticeMapper.findOne(notice_no);
		model.addAttribute("professorNotice", professorNoice);
		return "professor/noticecontentedit"; // 과제 및 공지 작성 페이지
	}

	@PostMapping(value = "noticecontentedit", params="cmd=edit")
	public String noticecontentedit2(Model model,Principal principal, ProfessorNotice professorNoice, @RequestParam("notice_no") int notice_no,@RequestParam("lecture_no") int lecture_no) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("professor", professor);
		Lecture lecture = lectureMapper.findOne(lecture_no);
		model.addAttribute("lecture", lecture);
		professorNoticeMapper.update(professorNoice);
		return "redirect:noticecontent?id="+notice_no; // 과제 및 공지 작성 페이지
	}

	@GetMapping("lecturefile")
	public String lecturefile(Model model, Principal principal, @RequestParam(value = "id") int id) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("files", lecturefileService.findAll(id)); // 업로드된 파일리스트
		return "professor/lecturefile"; // 강의자료 페이지
	}

	@PostMapping(value = "lecturefile", params = "cmd=upload") // 파일 업로드
	public String upload(Model model, @RequestParam("upload") MultipartFile[] upload, @RequestParam("id") int id)
			throws IOException {
		for (MultipartFile multipartFile : upload) {
			if (multipartFile.getSize() <= 0)
				continue;
			lecturefileService.save(multipartFile, id);
		}
		return "redirect:lecturefile?id=" + id;
	}

	@RequestMapping(value = "lecturefile/deletefile") // 파일 삭제
	public String delete(Model model, @RequestParam(value = "no") int no, @RequestParam(value = "id") int id) throws Exception {
		lecturefileService.delete(no);
		return "redirect:?id=" + id;
	}

	@RequestMapping(value = "lecturefile/download")
	public void download(@RequestParam("no") int no, HttpServletResponse response) throws Exception {
		Lecturefile lecturefile = lecturefileService.getUploadedFile(no);
		if (lecturefile == null)
			return;
		String fileName = URLEncoder.encode(lecturefile.getFile_name(), "UTF-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
			output.write(lecturefile.getData());
		}
	}

	@GetMapping("mypage")
	public String mypage(Model model, Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("professor", professor);
		return "professor/mypage"; // 학생 게시판 페이지

	}

	@PostMapping("mypage")
	public String mypage(Professor professor1, Model model, Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		professor.setName(professor1.getName());
		professor.setProfessor_email(professor1.getProfessor_email());
		professor.setProfessor_phone(professor1.getProfessor_phone());
		professor.setPassword_question(professor1.getPassword_question());
		professor.setPassword_answer(professor1.getPassword_answer());
		professor.setPassword1(professor1.getPassword1());
		professor.setPassword2(professor1.getPassword2());
		professorMapper.update(professor);
		User user = userMapper.findByLoginId(principal.getName());
		user.setName(professor.getName());
		user.setDepartment_no(professor.getDepartment_no());
		user.setEmail(professor.getProfessor_email());
		user.setPassword_question(professor.getPassword_question());
		user.setPassword_answer(professor.getPassword_answer());
		user.setPassword1(professor.getPassword1());

		userMapper.update(user);
		return "redirect:mypage"; // 학생 게시판 페이지

	}

	@RequestMapping("information")
	public String information(Model model,Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("professor", professor);
		return "professor/information"; // 도움말 페이지
	}

	@RequestMapping("studentnotice")
	public String studentnotice(Model model,Principal principal, @RequestParam("id") int id) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		List<StudentNotice> studentNotices = studentNoticeService.listWithStudentName(id);

		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("studentNotices", studentNotices);
		return "professor/studentnotice"; // 학생 게시판 페이지
	}


	@RequestMapping(value="inputscore", method=RequestMethod.GET)
	public String inputscore1(Model model, Principal principal, @RequestParam("notice_no") int notice_no) {
		// id notice_no를 받아와야함.... 지금 임의의 값을 주고 있음
		List<Homework> homeworks = homeworkMapper.findNotoiceStudents(notice_no);

		model.addAttribute("homeworks", homeworks);

		return "professor/inputscore";
	}

	@RequestMapping(value="inputscore", method=RequestMethod.POST, params="cmd=input")
	public String inputscore2(Model model,
			@RequestParam("notice_no") int notice_no,
			@RequestParam("hw_no") int[] hw_no,
			@RequestParam("grade") int[] grade,
			@RequestParam("ranking") int[] ranking) {

		List<Homework> homeworks = homeworkMapper.findNotoiceStudents(notice_no);
		
		for (int i=0; i < hw_no.length ;++i) {
			System.out.println("======================");
			homeworkMapper.gradeUpdate(grade[i], ranking[i], hw_no[i]);
			System.out.printf("점수 : %d,	등수 : %d, 과제번호 :%d\n",grade[i], ranking[i], hw_no[i]);
			System.out.println("======================\n\n");
		}
		
		model.addAttribute("homeworks", homeworks);
		return "redirect:inputscore?notice_no="+notice_no;
	}


	@GetMapping("studentcontent")
	public String studentcontent(Model model, Principal principal,
								 @RequestParam("id") int id ){
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		StudentNotice studentNotice = studentNoticeMapper.findOne(id);
        Lecture lecture = lectureMapper.findOne(studentNotice.getLecture_no());

//		System.out.println(studentNotice.getStudent_no());
//		System.out.println(principal.getName());

		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("studentNotice", studentNotice);

		return "professor/studentcontent"; // 학생 게시판 페이지
	}

	
	
	@RequestMapping(value="taapprove", method=RequestMethod.GET)
	public String taapprove(Model model, Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> taNoLecture = professorMapper.findBytaNO(principal.getName());
		List<Lecture> taYesLecture = professorMapper.findBytaYES(principal.getName());
		//Ta ta = taMapper.findOne(professor.getTa_no());

		model.addAttribute("taNoLecture", taNoLecture);
		model.addAttribute("taYesLecture", taYesLecture);
		model.addAttribute("professor", professor);

		if(professor.getTa_no() > 0) {
			Ta ta = taMapper.findOne(professor.getTa_no());
			model.addAttribute("ta", ta);
			System.out.printf("%s %s\n", ta.getTa_id(),ta.getPassword());
		}


		return "professor/taapprove";
	}

	@RequestMapping(value="taapprove", method=RequestMethod.POST, params="cmd=yes")
	public String taLectureYes(Model model, @RequestParam("id") int id, Principal principal, Lecture lecture) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> taNoLecture = professorMapper.findBytaNO(principal.getName());
		List<Lecture> taYesLecture = professorMapper.findBytaYES(principal.getName());
		Ta ta = taMapper.findOne(professor.getTa_no());

		model.addAttribute("taNoLecture", taNoLecture);
		model.addAttribute("taYesLecture", taYesLecture);
		model.addAttribute("professor", professor);
		model.addAttribute("ta", ta);

		lectureService.taYesLecture(professor.getTa_no(), id);

		System.out.printf("%d\n", lecture.getTa_no());

		return "redirect:taapprove";
	}

	@RequestMapping(value="taapprove", method=RequestMethod.POST, params="cmd=no")
	public String taLectureNo(Model model, @RequestParam("id") int id, Principal principal, Lecture lecture) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> taNoLecture = professorMapper.findBytaNO(principal.getName());
		List<Lecture> taYesLecture = professorMapper.findBytaYES(principal.getName());
		Ta ta = taMapper.findOne(professor.getTa_no());

		model.addAttribute("taNoLecture", taNoLecture);
		model.addAttribute("taYesLecture", taYesLecture);
		model.addAttribute("professor", professor);
		model.addAttribute("ta", ta);

		lectureService.taNoLecture(id);

		return "redirect:taapprove";
	}


	@GetMapping(value="createta")
	public String professorcreate(Model model, Principal principal) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		model.addAttribute("ta", new Ta());
		model.addAttribute("user", new User());

		return "professor/createta";
	}

	@PostMapping(value="createta")
	public String professorcreate(Model model, Principal principal, Ta ta , User user) {
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		taMapper.insert(ta);

		user.setId(ta.getTa_id());
		user.setPassword1(ta.getPassword());
		userMapper.taInsert(user);

		professorMapper.taUpdate(ta.getTa_no(), professor.getProfessor_no());

		System.out.printf("%s %s\n", professor.getName(), professor.getPassword1());
		System.out.printf("%d TA아이디 : %s, TA비밀번호 : %s\n", ta.getTa_no(),ta.getTa_id() ,ta.getPassword());

		System.out.printf("TA아이디 : %s, TA비밀번호 : %s\n", user.getId() ,user.getPassword1());
		return "professor/main";
	}



}