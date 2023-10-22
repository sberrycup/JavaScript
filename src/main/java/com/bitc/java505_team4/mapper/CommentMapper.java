package com.bitc.java505_team4.mapper;

import com.bitc.java505_team4.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    //    해당 게시물 댓글 리스트
    List<CommentDTO> selectCommentList(int idx) throws Exception;

    //    댓글 등록
    void insertComment(CommentDTO comment) throws Exception;

    //    댓글 수정
    void updateComment(CommentDTO comment) throws Exception;

    //    댓글 삭제
    void deleteComment(int commentNum, int commentBoardNum) throws Exception;
//    관리자 댓글 삭제(*)
}
