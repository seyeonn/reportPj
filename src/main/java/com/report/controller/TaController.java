package com.report.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.Arrays;
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

import com.report.dto.Comment;
import com.report.dto.Homework;
import com.report.dto.Lecture;
import com.report.dto.Lecturefile;
import com.report.dto.Professor;
import com.report.dto.ProfessorNotice;
import com.report.dto.StudentNotice;
import com.report.dto.Ta;
import com.report.dto.User;
import com.report.mapper.HomeworkMapper;
import com.report.mapper.LectureMapper;
import com.report.mapper.LecturefileMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.ProfessorNoticeMapper;
import com.report.mapper.StudentNoticeMapper;
import com.report.mapper.TaMapper;
import com.report.mapper.TimelineMapper;
import com.report.mapper.UserMapper;
import com.report.model.Pagination;
import com.report.service.CommentService;
import com.report.service.LecturefileService;
import com.report.service.StudentNoticeService;
import com.report.service.StudentUploadedFileService;

@Controller

@RequestMapping("ta")
public class TaController {

	@Autowired TaMapper taMapper;
	@Autowired LectureMapper lectureMapper;
	@Autowired ProfessorMapper professorMapper;
	@Autowired ProfessorNoticeMapper professorNoticeMapper;
	@Autowired HomeworkMapper homeworkMapper;
	@Autowired LecturefileMapper lecturefileMapper;
	@Autowired LecturefileService lecturefileService;
	@Autowired StudentNoticeService studentNoticeService;
	@Autowired StudentNoticeMapper studentNoticeMapper;
	@Autowired TimelineMapper timelineMapper;
	@Autowired UserMapper userMapper;
	@Autowired CommentService commentService;
    @Autowired StudentUploadedFileService studentUploadedFileService;

	@RequestMapping("taMain")
	public String taMain(Model model, Principal principal, Pagination pagination) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Professor professor = professorMapper.findByProfessorId(principal.getName());
		List<Lecture> taLecture = lectureMapper.findByTaLecture(ta.getTa_no());
		List<Lecture> timeline = timelineMapper.findAllByTa(ta.getTa_no(), pagination);
		pagination.setRecordCount(timelineMapper.countByTa(ta.getTa_no()));
		model.addAttribute("timeline",  timeline);
		model.addAttribute("ta", ta);
		model.addAttribute("professor", professor);
		model.addAttribute("taLecture", taLecture);


		return "ta/main"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@RequestMapping(value = "taMain", params="cmd=downloadLecturefile")
	public void taMaindownloadLecturefile(@RequestParam("no") int no, HttpServletResponse response) throws Exception {
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

	@RequestMapping("information")
	public String information(Model model, Principal principal) {
		Ta ta = taMapper.findByTaId(principal.getName());
		model.addAttribute("ta", ta);
		return "ta/information"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@RequestMapping("studentnotice")
	public String studentnotice(Model model,Principal principal, @RequestParam("id") int id, Pagination pagination) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		List<StudentNotice> studentNotices = studentNoticeService.listWithStudentName(id,pagination);
		pagination.setRecordCount(lecturefileMapper.count(id));
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		model.addAttribute("studentNotices", studentNotices);
		return "ta/studentnotice"; // 학생 게시판 페이지
	}

	@GetMapping("studentcontent")
	public String studentcontent(Model model, Principal principal,
								 @RequestParam("id") int id ){
		Ta ta = taMapper.findByTaId(principal.getName());
		StudentNotice studentNotice = studentNoticeMapper.findOne(id);
        Lecture lecture = lectureMapper.findOne(studentNotice.getLecture_no());

//		System.out.println(studentNotice.getStudent_no());
//		System.out.println(principal.getName());

		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		model.addAttribute("studentNotice", studentNotice);

		return "ta/studentcontent"; // 학생 게시판 페이지
	}

	@RequestMapping("mypage")
	public String mypage(Model model, Principal principal) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Professor professor = professorMapper.findByTa(ta.getTa_no());
		model.addAttribute("ta", ta);
		model.addAttribute("professor", professor);
		return "ta/mypage"; // 로그인 한 ta를 위한 메인 페이지 URL
	}

	@PostMapping("mypage")
    public String mypage(Ta ta1, Model model, Principal principal, HttpServletResponse response) throws IOException {
       Ta ta = taMapper.findByTaId(principal.getName());
       ta.setPassword(ta1.getPassword());

       taMapper.update(ta);

       User user = userMapper.findByLoginId(principal.getName());
		user.setPassword1(ta.getPassword());
		userMapper.taupdate(user);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('마이페이지 수정 완료.'); history.go(-1);</script>");
        out.flush();
       return "redirect:mypage"; // 학생 마이페이지
	}

	@RequestMapping("notice")
	public String notice(Model model, Principal principal, @RequestParam("id") int id,Pagination pagination) {
		Ta ta = taMapper.findByTaId(principal.getName());
		model.addAttribute("ta", ta);
		Lecture lecture = lectureMapper.findOne(id);
		List<ProfessorNotice>  professorNotices = professorNoticeMapper.list(id, pagination);
		pagination.setRecordCount(professorNoticeMapper.count(id));
		model.addAttribute("lecture", lecture);
		model.addAttribute("professorNotices", professorNotices);
		return "ta/notice"; // 과제 및 공지 페이지
	}

	@RequestMapping("lecturefile")
	public String lecturefile(Model model, Principal principal, @RequestParam("id") int id, Pagination pagination) {
		Ta ta = taMapper.findByTaId(principal.getName());
		Lecture lecture = lectureMapper.findOne(id);
		List<Lecturefile> lecturefiles = lecturefileService.findAll(id,pagination);
		pagination.setRecordCount(lecturefileMapper.count(id));
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		model.addAttribute("files", lecturefiles); // 업로드된 파일리스트
		return "ta/lecturefile"; // 강의자료 페이지
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

	@GetMapping("noticecontent")
	public String noticecontent(Model model,Principal principal, @RequestParam("id") int id) {
		Ta ta = taMapper.findByTaId(principal.getName());
		ProfessorNotice professorNotice = professorNoticeMapper.findOne(id);
		Lecture lecture = lectureMapper.findOne(professorNotice.getLecture_no());
		List<Comment> comments = commentService.listWithUserName(professorNotice.getNotice_no());
		User user = userMapper.findByLoginId(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("comment", comments);
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		model.addAttribute("professorNotice", professorNotice);
		return "ta/noticecontent"; // 과제 및 공지 작성 페이지
	}

	@PostMapping(value = "noticecontent", params = "cmd=insertComment")
	public String insertComment(Model model, Principal principal, Comment newComment, @RequestParam("notice_no") int notice_no){
        User user = userMapper.findByLoginId(principal.getName());
        System.out.println(user.getName());

        newComment.setNotice_no(notice_no);
        newComment.setNo(user.getNo());

        model.addAttribute("user", user);

		commentService.insert(newComment);
		return "redirect:noticecontent?id="+notice_no;
	}

	@PostMapping(value = "noticecontent", params = "cmd=deleteComment")
	public String deleteComment(@RequestParam("comment_no")int comment_no,
								@RequestParam("notice_no")int notice_no){
		commentService.delete(comment_no);
		return "redirect:noticecontent?id="+notice_no;
	}

	@RequestMapping(value="inputscore", method=RequestMethod.GET)
	public String inputscore1(Model model, Principal principal, @RequestParam("notice_no") int notice_no) {
		// id notice_no를 받아와야함.... 지금 임의의 값을 주고 있음
		List<Homework> homeworks = homeworkMapper.findNotoiceStudents(notice_no);
		model.addAttribute("homeworks", homeworks);
		Ta ta = taMapper.findByTaId(principal.getName());
		ProfessorNotice professorNotice = professorNoticeMapper.findOne(notice_no);
		Lecture lecture = lectureMapper.findOne(professorNotice.getLecture_no());
		model.addAttribute("lecture", lecture);
		model.addAttribute("ta", ta);
		model.addAttribute("professorNotice", professorNotice);
		return "ta/inputscore";
	}

	@RequestMapping(value="inputscore", params ="cmd=downloadHomework")
	public void downloadHomework(@RequestParam("hw_no") int hw_no, HttpServletResponse response) throws Exception {
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


	@RequestMapping(value="inputscore", method=RequestMethod.POST, params="cmd=input")
	public String inputscore2(Model model, Principal principal,
			@RequestParam(value="notice_no", required = false, defaultValue = "notice_no") int notice_no,
			@RequestParam(value="hw_no", required = false, defaultValue = "hw_no") int[] hw_no,
			@RequestParam(value="grade", required = false, defaultValue = "grade") int[] grade,
			@RequestParam(value="ranking", required = false, defaultValue = "ranking") int[] ranking) {


		Ta ta = taMapper.findByTaId(principal.getName());
		ProfessorNotice professorNotice = professorNoticeMapper.findOne(notice_no);
		List<Homework> homeworks = homeworkMapper.findNotoiceStudents(notice_no);
		Lecture lecture = lectureMapper.findOne(professorNotice.getLecture_no());


		model.addAttribute("ta", ta);
		model.addAttribute("professorNotice", professorNotice);
		model.addAttribute("homeworks", homeworks);
		model.addAttribute("lecture", lecture);



		for (int i=0; i < hw_no.length ;++i) {
			homeworkMapper.gradeUpdate(grade[i], hw_no[i]);
		}


		return "redirect:inputscore?notice_no="+notice_no;
	}

	@RequestMapping(value="inputscore", method=RequestMethod.POST, params="cmd=rank")
	public String inputscore3(Model model, Principal principal,
			@RequestParam(value="notice_no", required = false, defaultValue = "notice_no") int notice_no,
			@RequestParam(value="hw_no", required = false, defaultValue = "hw_no")  Integer[] hw_no,
			@RequestParam(value="grade", required = false, defaultValue = "grade")  Integer[] grade,
			@RequestParam(value="ranking", required = false, defaultValue = "ranking")  Integer[] ranking) {

		Ta ta = taMapper.findByTaId(principal.getName());
		ProfessorNotice professorNotice = professorNoticeMapper.findOne(notice_no);
		List<Homework> homeworks = homeworkMapper.findNotoiceStudents(notice_no);
		Lecture lecture = lectureMapper.findOne(professorNotice.getLecture_no());


		int[] score = new int[grade.length];
		int[] rank = new int [grade.length];

		for(int i=0 ; i<grade.length; i++) {
			score[i]=grade[i];
		}


		for(int x=0; x<grade.length; x++) {
			rank[x]=1;
			for(int y=0; y<grade.length; y++) {
				if(score[x]<score[y])
					rank[x]++;
			}
		}

		Arrays.sort(rank);

		for(int i=0; i<hw_no.length; ++i) {
			System.out.printf("%d %d %s\n", score[i], rank[i], homeworks.get(i).getStudent().getName());
		}

		for (int i=0; i < hw_no.length ;++i) {

			System.out.printf("[%d] : %s	-> %d\n======================\n",homeworks.get(i).getRanking(), homeworks.get(i).getStudent().getName(), homeworks.get(i).getGrade());
			homeworkMapper.rankUpdate(rank[i], hw_no[i]);
		}


		model.addAttribute("ta", ta);
		model.addAttribute("professorNotice", professorNotice);
		model.addAttribute("homeworks", homeworks);
		model.addAttribute("lecture", lecture);

		return "redirect:inputscore?notice_no="+notice_no;
	}



}
