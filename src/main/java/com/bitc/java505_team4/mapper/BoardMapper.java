package com.bitc.java505_team4.mapper;

import com.bitc.java505_team4.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

//    전체 게시물 리스트
    List<BoardDTO> selectBoardList(int limit, int offset) throws Exception;

//    게시글 수정
    void updateBoard(BoardDTO board) throws Exception;

// 게시글 등록
    void insertBoard(BoardDTO board) throws Exception;

// 게시글 삭제
    void deleteBoard(int boardNum) throws Exception;

    void likeUpdate(int boardNum) throws Exception;


    int getBoardCount() throws  Exception;

}









































