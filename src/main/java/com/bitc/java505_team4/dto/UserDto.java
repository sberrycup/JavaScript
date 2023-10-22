package com.bitc.java505_team4.dto;

import lombok.Data;

@Data
public class UserDto {
    private int memberNum;
    private String memberEmail;
    private String memberPw;
    private String memberName;
    private String adminYn;

    private String memberProfileName;
    private String memberProfilePath;
}
