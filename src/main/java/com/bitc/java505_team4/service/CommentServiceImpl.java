package com.bitc.java505_team4.service;

import com.bitc.java505_team4.dto.CommentDTO;
import com.bitc.java505_team4.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<CommentDTO> selectCommentList(int idx) throws Exception {
        return commentMapper.selectCommentList(idx);
    }

    @Override
    public void insertComment(CommentDTO comment) throws Exception {
        commentMapper.insertComment(comment);
    }

    @Override
    public void updateComment(CommentDTO comment) throws Exception {
        commentMapper.updateComment(comment);
    }

    @Override
    public void deleteComment(int commentNum, int commentBoardNum) throws Exception {
        commentMapper.deleteComment(commentNum, commentBoardNum);
    }
}
