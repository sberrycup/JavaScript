package com.bitc.java505_team4.service;

import com.bitc.java505_team4.dto.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<CommentDTO> selectCommentList(int idx) throws Exception;

    //    댓글 등록
    void insertComment(CommentDTO comment) throws Exception;

    //    댓글 수정
    void updateComment(CommentDTO comment) throws Exception;

    //    댓글 삭제
    void deleteComment(int commentNum, int commentBoardNum) throws Exception;
}
