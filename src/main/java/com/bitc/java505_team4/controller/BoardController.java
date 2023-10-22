package com.bitc.java505_team4.controller;

import com.bitc.java505_team4.dto.BoardDTO;
import com.bitc.java505_team4.dto.UserDto;
import com.bitc.java505_team4.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;


//        메인 페이지 출력만
    @RequestMapping(value = "/main/", method = RequestMethod.GET)
    public ModelAndView mainPage(HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("main/mainBoard2");

        HttpSession session = req.getSession();

        UserDto user = new UserDto();
        user.setMemberEmail((String)session.getAttribute("memberEmail"));
        user.setMemberName((String)session.getAttribute("memberName"));
        user.setAdminYn((String)session.getAttribute("adminYn"));
        user.setMemberProfilePath((String)session.getAttribute("memberProfilePath"));

        mv.addObject("userInfo", user);

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/main/getTotalRows", method = RequestMethod.GET)
    public int getTotalRows() throws Exception {
        int totalRows = boardService.getBoardCount();
        return totalRows;
    }

    @ResponseBody
    @RequestMapping(value = "/main/process", method = RequestMethod.POST)
    public Object mainList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws Exception {
        List<BoardDTO> boardList = boardService.selectBoardList(limit, offset);
        // Jackson ObjectMapper를 사용하여 List<BoardDTO>를 JSON 문자열로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(boardList);

        return json;
    }

//    @RequestMapping(value = "/main/process", method = RequestMethod.POST)
//    public ModelAndView mainList() throws Exception {
//        ModelAndView mv = new ModelAndView("main/mainBoard");
//
//        List<BoardDTO> boardList = boardService.selectBoardList();
//        mv.addObject("boardList", boardList);
//
//        return mv;
//    }

    //    게시글 수정
    @ResponseBody
    @RequestMapping(value = "/main/update", method = RequestMethod.POST)
    public String boardUpdateProcess(@RequestParam("boardNum") int boardNum, @RequestParam("boardContents") String boardContents) throws Exception {

        BoardDTO board = new BoardDTO();
        board.setBoardNum(boardNum);
        board.setBoardContents(boardContents);

        boardService.updateBoard(board);
        return "success";
    }

    //    게시글 등록 (내부 프로세스)
    @RequestMapping(value = "/main/insert", method = RequestMethod.POST)
    public String boardInsertProcess(BoardDTO board, HttpServletRequest req, MultipartHttpServletRequest uploadFiles) throws Exception {
        HttpSession session = req.getSession();

        board.setBoardMemberName((String)session.getAttribute("memberName"));
        boardService.insertBoard(board, uploadFiles);
        return "redirect:/main/";
    }

    //    게시글 삭제
    @ResponseBody
    @RequestMapping(value = "/main/delete", method = RequestMethod.POST)
    public String boardDelete(@RequestParam("boardNum") int boardNum) throws Exception {
        boardService.deleteBoard(boardNum);
        return "success";
    }
}














































