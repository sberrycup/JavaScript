package com.bitc.java505_team4.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardDTO {
    private int boardNum;
    private String boardTitle;
    private String boardMemberName;
    private String boardContents;
    private String boardDate;
    private String boardFile;
    private String boardImg;
    private int boardLike;
    private List<CommentDTO> commentList;
//    private int commentNum;
//    private String commentMemberName;
//    private String commentContents;
//    private String commentDate;
//    private int commentBoardNum;
}
