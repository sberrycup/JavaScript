package com.bitc.java505_team4.controller;

import com.bitc.java505_team4.dto.CommentDTO;
import com.bitc.java505_team4.service.BoardService;
import com.bitc.java505_team4.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardService boardService;

//    @RequestMapping(value = "/main/comment", method = RequestMethod.GET)
//    public ModelAndView commentList() throws Exception {
//        ModelAndView mv = new ModelAndView("main/mainBoard");
//
//        List<CommentDTO> commentList = commentService.selectCommentList();
//
//        mv.addObject("commentList", commentList);
//        return mv;
//    }

//    댓글 등록
    @ResponseBody
    @RequestMapping(value = "/main/insertComment", method = RequestMethod.POST)
    public CommentDTO commentInsertProcess(@RequestParam("comment") String comment, @RequestParam("commentBoardNum") int commentBoardNum, HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentMemberName((String)session.getAttribute("memberName"));
        commentDTO.setCommentBoardNum(commentBoardNum);
        commentDTO.setCommentContents(comment);
        commentService.insertComment(commentDTO);
        return commentDTO;
    }

    //    댓글 수정
    @ResponseBody
    @RequestMapping(value = "/main/updateComment", method = RequestMethod.POST)
    public String commentUpdateProcess(@RequestParam("commentBoardNum") int commentBoardNum, @RequestParam("commentNum") int commentNum, @RequestParam("commentContents") String commentContents) throws Exception {
        CommentDTO comment = new CommentDTO();
        comment.setCommentNum(commentNum);
        comment.setCommentBoardNum(commentBoardNum);
        comment.setCommentContents(commentContents);

        commentService.updateComment(comment);
        return "success";
    }

//    댓글 삭제
    @ResponseBody
    @RequestMapping(value = "/main/deleteComment", method = RequestMethod.POST)
    public String commentDeleteProcess(@RequestParam("commentNum") int commentNum, @RequestParam("commentBoardNum") int commentBoardNum) throws Exception {
        commentService.deleteComment(commentNum, commentBoardNum);
        return "success";
    }


}
