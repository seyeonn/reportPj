package com.report.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.report.dto.Comment;
import com.report.dto.Homework;
import com.report.dto.Lecture;
import com.report.dto.Lecturefile;
import com.report.dto.Professor;
import com.report.dto.ProfessorLecture;
import com.report.dto.ProfessorNotice;
import com.report.dto.Student;
import com.report.dto.StudentLecture;
import com.report.dto.StudentNotice;
import com.report.dto.User;
import com.report.mapper.HomeworkMapper;
import com.report.mapper.LectureMapper;
import com.report.mapper.LecturefileMapper;
import com.report.mapper.ProfessorLectureMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.ProfessorNoticeMapper;
import com.report.mapper.StudentLectureMapper;
import com.report.mapper.StudentMapper;
import com.report.mapper.StudentNoticeMapper;
import com.report.mapper.TimelineMapper;
import com.report.mapper.UserMapper;
import com.report.model.Pagination;
import com.report.service.CommentService;
import com.report.service.LectureService;
import com.report.service.LecturefileService;
import com.report.service.StudentNoticeService;
import com.report.service.StudentUploadedFileService;

@Controller

@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	ProfessorMapper professorMapper;
	@Autowired
	LectureMapper lectureMapper;
	@Autowired
	LectureService lectureService;
	@Autowired
	ProfessorLectureMapper professorLectureMapper;
	@Autowired
	StudentLectureMapper studentLectureMapper;
	@Autowired
	StudentNoticeService studentNoticeService;
	@Autowired
	ProfessorNoticeMapper professorNoticeMapper;
	@Autowired
	StudentNoticeMapper studentNoticeMapper;
	@Autowired UserMapper userMapper;
	@Autowired StudentUploadedFileService studentUploadedFileService;
	@Autowired LecturefileService lecturefileService;
	@Autowired LecturefileMapper lecturefileMapper;
	@Autowired TimelineMapper timelineMapper;
	@Autowired CommentService commentService;
	@Autowired HomeworkMapper homeworkMapper;

	@RequestMapping("studentMain")
	public String studentMain(Model model, Principal principal, Pagination pagination) {
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		List<Lecture> timeline = timelineMapper.findAllByStudent(student.getStudent_no(), pagination);
		pagination.setRecordCount(timelineMapper.countByStudent(student.getStudent_no()));
		model.addAttribute("timeline",  timeline);
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("student", student);
		return "student/main"; // 로그인 한 학생을 위한 메인 페이지 URL

	}

	@RequestMapping(value = "studentMain", params="cmd=downloadLecturefile")
	public void studentMaindownloadLecturefile(@RequestParam("no") int no, HttpServletResponse response) throws Exception {
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

	@RequestMapping(value="lecture", method=RequestMethod.GET)
	public String studentlecture(Model model, Lecture lecture, Principal principal,
			Pagination pagination) {

		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		//List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		//model.addAttribute("lectures", lectures);

		List<Lecture> lectures = lectureMapper.findA(student.getStudent_no(),pagination);
		pagination.setRecordCount(lectureMapper.count(student.getStudent_no()));
		model.addAttribute("lectures", lectures);

		model.addAttribute("studentLecture", new StudentLecture());
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}

	@RequestMapping(value="lecture", method=RequestMethod.POST, params="cmd=delete")
	public String studentlecture1(Model model, @RequestParam("id") int id, Principal principal,
			Lecture lecture, StudentLecture studentLecture) {
		System.out.printf("%d\n", id);
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("lectures", lectures);
		model.addAttribute("student", student);
		model.addAttribute("studentLecture", studentLecture);

		lectureService.studentLectureDelete(id, student.getStudent_no());

		System.out.printf("%s, %s\n", student.getName(), lecture.getLecture_name());
		return "redirect:lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}



	@RequestMapping(value="lecture", method=RequestMethod.POST, params="cmd=insert")
	public String studentlecture2(Model model, @RequestParam("id") int id, Principal principal, Lecture lecture, StudentLecture studentLecture) {
		System.out.printf("%d\n", id);
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		model.addAttribute("lectures", lectures);
		model.addAttribute("student", student);
		model.addAttribute("studentLecture", studentLecture);

		lectureService.studentSave(id, student.getStudent_no());

		System.out.printf("%s, %s\n", student.getName(), lecture.getLecture_name());
		return "redirect:lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}

	@RequestMapping(value="lecture", method=RequestMethod.POST, params="cmd=search")
	public String studentlecture3(Model model, Lecture lecture, Principal principal,
			Pagination pagination, @RequestParam("search") String search) {

		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecture> studentlectures1 = studentMapper.findByStudentLecture1(principal.getName());
		List<Lecture> studentlectures2 = studentMapper.findByStudentLecture2(principal.getName());
		//List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("studentlectures1",studentlectures1);
		model.addAttribute("studentlectures2",studentlectures2);
		//model.addAttribute("lectures", lectures);

		List<Lecture> lectures = lectureMapper.findSearch(student.getStudent_no(),pagination,search);
		pagination.setRecordCount(lectureMapper.countSearch(student.getStudent_no(),search));
		model.addAttribute("lectures", lectures);

		System.out.println(search+"  "+lectures.size());
		model.addAttribute("studentLecture", new StudentLecture());
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		return "student/lecture"; // 로그인 한 학생을 위한 메인 페이지 URL

	}


	@RequestMapping("notice")
	public String notice(Model model, Principal principal, @RequestParam("id") int id, Pagination pagination) {
		Lecture lecture = lectureMapper.findOne(id);
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
		Student student = studentMapper.findByStudentId(principal.getName());
		List<ProfessorNotice>  professorNotices = professorNoticeMapper.list(lecture.getLecture_no(), pagination);
		pagination.setRecordCount(professorNoticeMapper.count(id));
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("professorNotices", professorNotices);

		System.out.println(professorNotices.size());
		return "student/notice"; // 과제 및 공지 페이지
	}

	@RequestMapping("studentnotice")
	public String list(Model model, Principal principal, @RequestParam("id") int id,Pagination pagination) {
		List<StudentNotice> studentNotices = studentNoticeService.listWithStudentName(id,pagination);
		pagination.setRecordCount(lecturefileMapper.count(id));
		Student student = studentMapper.findByStudentId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());

		model.addAttribute("studentNotices", studentNotices);
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);

		return "student/studentnotice";
	}//학생 게시판 목록

	@GetMapping("studentcontent")
	public String studentContent(Model model, Principal principal, @RequestParam("id") int id) {
		Student student = studentMapper.findByStudentId(principal.getName());
		System.out.println(principal.getName());

		StudentNotice studentNotice = studentNoticeMapper.findOne(id);
		System.out.println(studentNotice.getLecture_no());

		Lecture lecture = lectureMapper.findOne(studentNotice.getLecture_no());
		System.out.println(lecture.getLecture_name());

		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());

		model.addAttribute("lecture", lecture);
		model.addAttribute("student", student);
		model.addAttribute("studentNotice", studentNotice);
		model.addAttribute("professor", professor);

		System.out.println("여기까지1");

		return "student/studentcontent";
	}//게시글 조회

	@GetMapping("studentposting")
	public String studentPosting(Model model, Principal principal, @RequestParam("id") int id) {
		studentNoticeService.insert(model, id, principal);
		return "student/studentposting";
	}//게시글 작성

	@PostMapping("studentposting")
	public String studentPosting(Model model, Principal principal, @RequestParam("id") int id, StudentNotice newStudentNotice) {
		studentNoticeService.insert(model, principal, newStudentNotice, id);
		return "redirect:studentnotice?id=" + id;
	}//게시글 작성


	@PostMapping(value = "studentcontent", params="cmd=delete")
	public String studentContentDelete(Model model,Principal principal,
			@RequestParam("studentnotice_no") int studentnotice_no,
			@RequestParam("lecture_no") int lecture_no) {

		System.out.println("여기까지2");

		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		Lecture lecture = lectureMapper.findOne(lecture_no);
		model.addAttribute("lecture", lecture);

		studentNoticeMapper.delete(studentnotice_no);

		return "redirect:studentnotice?id=" + lecture_no;
	}//게시판 글 삭제

	@GetMapping("studentcontentedit")
	public String studentContentEdit(Model model, Principal principal,
			@RequestParam("studentnotice_no") int studentnotice_no,
			@RequestParam("lecture_no") int lecture_no) {
		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		Lecture lecture = lectureMapper.findOne(lecture_no);
		model.addAttribute("lecture", lecture);

		StudentNotice studentNotice = studentNoticeService.findOne(studentnotice_no);
		model.addAttribute("studentNotice", studentNotice);
		return "student/studentcontentedit"; // 과제 및 공지 작성 페이지
	}

	@PostMapping(value = "studentcontentedit", params = "cmd=edit")
	public String studentContentEdit(Model model, Principal principal, StudentNotice studentNotice,
			@RequestParam("studentnotice_no") int studentnotice_no,
			@RequestParam("lecture_no") int lecture_no) {
		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		Lecture lecture = lectureMapper.findOne(lecture_no);
		model.addAttribute("lecture", lecture);
		studentNoticeService.update(studentNotice);
		return "redirect:studentcontent?id=" + studentnotice_no; // 과제 및 공지 작성 페이지
	}

	@RequestMapping("lecturefile")
	public String lecturefile(Model model, Principal principal, @RequestParam("id") int id, Pagination pagination) {
		Lecture lecture = lectureMapper.findOne(id);
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
		Student student = studentMapper.findByStudentId(principal.getName());
		List<Lecturefile> lecturefiles = lecturefileService.findAll(id,pagination);
		pagination.setRecordCount(lecturefileMapper.count(id));
		model.addAttribute("student", student);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professor", professor);
		model.addAttribute("files", lecturefiles);// 업로드된 파일리스트

		return "student/lecturefile"; // 강의 자료 페이지

	}
	@RequestMapping(value = "lecturefile", params="cmd=downloadLecturefile")
	public void downloadLecturefile(@RequestParam("no") int no, HttpServletResponse response) throws Exception {
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
		Student student = studentMapper.findByStudentId(principal.getName());
		model.addAttribute("student", student);
		return "student/mypage"; // 학생 게시판 페이지

	}

	@PostMapping("mypage")
	public String mypage(Student student1, Model model, Principal principal, HttpServletResponse response) throws IOException {
		Student student = studentMapper.findByStudentId(principal.getName());
		student.setName(student1.getName());
		student.setDepartment_no(student1.getDepartment_no());
		student.setStudent_email(student1.getStudent_email());
		student.setStudent_phone(student1.getStudent_phone());
		student.setPassword_question(student1.getPassword_question());
		student.setPassword_answer(student1.getPassword_answer());
		student.setPassword1(student1.getPassword1());
		student.setPassword2(student1.getPassword2());
		studentMapper.update(student);

		User user = userMapper.findByLoginId(principal.getName());
		user.setName(student.getName());
		user.setDepartment_no(student.getDepartment_no());
		user.setEmail(student.getStudent_email());
		user.setPassword_question(student.getPassword_question());
		user.setPassword_answer(student.getPassword_answer());
		user.setPassword1(student.getPassword1());
		user.setPassword2(student.getPassword2());

		userMapper.update(user);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('마이페이지 수정 완료.'); history.go(-1);</script>");
		out.flush();
		return "redirect:mypage"; // 학생 마이페이지
	}

	@RequestMapping("information")
	public String information(Model model) {
		return "student/information"; // 학생 게시판 페이지

	}

	@GetMapping("noticecontent")
	public String noticecontent(Model model, Principal principal, @RequestParam("id") int id) {
		Student student = studentMapper.findByStudentId(principal.getName());
		ProfessorNotice professorNotice = professorNoticeMapper.findOne(id);
		Lecture lecture = lectureMapper.findOne(professorNotice.getLecture_no());
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
		User user = userMapper.findByLoginId(principal.getName());
		Homework homework = homeworkMapper.findByNo(student.getStudent_no(), professorNotice.getNotice_no());
		List<Comment> comments = commentService.listWithUserName(professorNotice.getNotice_no());
		model.addAttribute("user", user);
		model.addAttribute("comment", comments);
		model.addAttribute("professor", professor);
		model.addAttribute("lecture", lecture);
		model.addAttribute("professorNotice", professorNotice);
		model.addAttribute("student", student);
		model.addAttribute("homework", homework);
		return "student/noticecontent"; // 과제 및 공지 내용 페이지
	}

	@PostMapping(value = "noticecontent", params = "cmd=insertComment")
	public String insertComment(Model model, Principal principal, Comment newComment, @RequestParam("id") int id){
		User user = userMapper.findByLoginId(principal.getName());
		System.out.println(user.getNo());
		System.out.println("댓글 들어가라");
		newComment.setNotice_no(id);
		newComment.setNo(user.getNo());

		model.addAttribute("user", user);

		commentService.insert(newComment);
		System.out.println(newComment.getNo());

		return "redirect:noticecontent?id="+id;

	}

	@PostMapping(value = "noticecontent", params = "cmd=deleteComment")
	public String deleteComment(@RequestParam("comment_no")int comment_no,
			@RequestParam("id")int id){
		commentService.delete(comment_no);
		return "redirect:noticecontent?id="+id;
	}

	@RequestMapping("worksubmit")
	public String worksubmit(Model model, Principal principal, @RequestParam("id") int id,
			@RequestParam("id2") int id2) {
		ProfessorNotice professorNotice = professorNoticeMapper.findOne(id);
		Lecture lecture = lectureMapper.findOne(professorNotice.getLecture_no());
		ProfessorLecture professorLecture = professorLectureMapper.findOne(lecture.getLecture_no());
		Professor professor = professorMapper.findOne(professorLecture.getProfessor_no());
		Student student = studentMapper.findByStudentId(principal.getName());
		Student student2 = studentMapper.findOne(id2);
		List<Homework> list1 = studentUploadedFileService.findAll(id, id2);
		model.addAttribute("student2",student2);
		model.addAttribute("student", student);
		model.addAttribute("professorNotice", professorNotice);
		model.addAttribute("files", list1);
		model.addAttribute("professor", professor);
		model.addAttribute("lecture", lecture);

		System.out.println(studentMapper.findOne(id2).toString());
		return "student/worksubmit"; // 학생 게시판 페이지
	}

	@PostMapping(value = "worksubmit", params = "cmd=upload")
	public String upload(Model model, Principal principal, @RequestParam("upload") MultipartFile[] multipartFiles,
			@RequestParam("id") int id, @RequestParam("id2") int id2) throws IOException {
		for (MultipartFile multipartFile : multipartFiles) {
			if (multipartFile.getSize() <= 0)
				continue;
			studentUploadedFileService.insert(multipartFile, id, id2);
		}
		return "redirect:/student/worksubmit?id=" + id+"&id2="+id2;
	}

	@RequestMapping(value = "worksubmit", params="cmd=delete")
	public String delete(Model model, @RequestParam("hw_no") int hw_no, @RequestParam("id") int id, @RequestParam("id2") int id2) throws Exception {
		studentUploadedFileService.delete(hw_no);
		return "redirect:worksubmit?id="+id+"&id2="+id2;
	}

	@RequestMapping(value="worksubmit", params="cmd=download")
	public void download(@RequestParam("hw_no") int hw_no, HttpServletResponse response) throws Exception {
		Homework homework = studentUploadedFileService.getUploadedFile(hw_no);
		if (homework == null)
			return;
		String fileName = URLEncoder.encode(homework.getFile_name(), "UTF-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
			output.write(homework.getData());
		}
	}

}
