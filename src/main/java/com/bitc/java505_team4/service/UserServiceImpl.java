package com.bitc.java505_team4.service;

import com.bitc.java505_team4.common.ProfilePhotoUtil;
import com.bitc.java505_team4.dto.UserDto;
import com.bitc.java505_team4.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProfilePhotoUtil fileUtils;

    @Override
    public int isUserInfo(String memberEmail, String memberPw) throws Exception {
        return userMapper.isUserInfo(memberEmail, memberPw);
    }

    @Override
    public UserDto getUserInfo(String memberEmail) throws Exception {
        return userMapper.getUserInfo(memberEmail);
    }

    @Override
    public UserDto myUserDetail(String memberEmail) throws Exception {
        return userMapper.myUserDetail(memberEmail);
    }

    @Override
    public void myUserUpdate(UserDto userInfo, MultipartHttpServletRequest uploadFiles) throws Exception {
        userMapper.myUserUpdate(userInfo);
        List<UserDto> fileList = fileUtils.parseFileInfo(userInfo, uploadFiles);
        if (CollectionUtils.isEmpty(fileList) == false) {
            userMapper.updateUserProfile(fileList.get(0));
        }
    }

    @Override
    public void insertMembership(UserDto userdto) throws Exception {
        userMapper.insertMembership(userdto);
    }

    @Override
    public List<UserDto> selectMemberManage() throws Exception {
        return userMapper.selectMemberManage();
    }

    @Override
    public void updateUser(UserDto user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int memberNum) throws Exception {
        userMapper.deleteUser(memberNum);
    }
}