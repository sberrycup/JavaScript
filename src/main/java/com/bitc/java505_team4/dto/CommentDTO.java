package com.bitc.java505_team4.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private int commentNum;
    private String commentMemberName;
    private String commentContents;
    private String commentDate;
    private int commentBoardNum;

    private int boardNum;
}
