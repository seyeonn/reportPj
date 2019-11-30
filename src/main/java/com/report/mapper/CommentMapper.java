package com.report.mapper;

import com.report.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public List<Comment> listWithUserName(int notice_no);

    public void insert(Comment comment);
    public void update(Comment comment);
    public void delete(int comment_no);
}