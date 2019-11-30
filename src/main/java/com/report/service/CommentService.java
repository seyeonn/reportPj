package com.report.service;

import com.report.dto.Comment;
import com.report.dto.Lecture;
import com.report.dto.ProfessorNotice;
import com.report.dto.User;
import com.report.mapper.CommentMapper;
import com.report.mapper.LectureMapper;
import com.report.mapper.ProfessorNoticeMapper;
import com.report.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProfessorNoticeMapper professorNoticeMapper;

    public List<Comment> listWithUserName(int notice_no){
        return commentMapper.listWithUserName(notice_no);
    }

    public void insert(Comment newComment){
//        User user = userMapper.findByUserName(principal.getName());
//        Comment newComment = new Comment();
//        System.out.println(user.getId());
//
//        newComment.setNotice_no(notice_no);
//        newComment.setNo(no);
//
//        model.addAttribute("user", user);
//        model.addAttribute("comment", newComment);

        commentMapper.insert(newComment);
    }

//    public void update(Comment newComment){
//        commentMapper.update(newComment);
//    }

    public void delete(int comment_no){
        commentMapper.delete(comment_no);
    }

}