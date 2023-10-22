package com.bitc.java505_team4.service;

import com.bitc.java505_team4.common.BoardPhotoUtil;
import com.bitc.java505_team4.dto.BoardDTO;
import com.bitc.java505_team4.dto.CommentDTO;
import com.bitc.java505_team4.dto.UserDto;
import com.bitc.java505_team4.mapper.BoardMapper;
import com.bitc.java505_team4.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BoardPhotoUtil fileUtils;

    @Override
    public List<BoardDTO> selectBoardList(int limit, int offset) throws Exception {
        List<BoardDTO> boardList = boardMapper.selectBoardList(limit, offset);

        for (int i = 0; i < boardList.size(); i++) {
            List<CommentDTO> commentList = commentMapper.selectCommentList(boardList.get(i).getBoardNum());
            boardList.get(i).setCommentList(commentList);
        }

        return boardList;
    }
//    @Override
//    public List<BoardDTO> selectBoardList(int limit, int offset) throws Exception {
//        List<BoardDTO> boardList = boardMapper.selectBoardList(limit, offset);
//
//        for (int i = 0; i < boardList.size(); i++) {
//            List<CommentDTO> commentList = commentMapper.selectCommentList(boardList.get(i).getBoardNum());
//            boardList.get(i).setCommentList(commentList);
//        }
//
//        return boardList;
//    }


    @Override
    public void updateBoard(BoardDTO board) throws Exception {
        boardMapper.updateBoard(board);
    }

    @Override
    public void insertBoard(BoardDTO board, MultipartHttpServletRequest uploadFiles) throws Exception {
        boardMapper.insertBoard(board);
        List<BoardDTO> fileList = fileUtils.parseFileInfo(board, uploadFiles);
        if (CollectionUtils.isEmpty(fileList) == false) {
            boardMapper.insertBoard(fileList.get(0));
        }
    }

    @Override
    public void deleteBoard(int boardNum) throws Exception {
        boardMapper.deleteBoard(boardNum);
    }

    @Override
    public void likeUpload(int boardNum) throws Exception{
        boardMapper.likeUpdate(boardNum);
    }

    @Override
    public int getBoardCount() throws Exception {
        return boardMapper.getBoardCount();
    }
}

































