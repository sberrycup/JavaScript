package com.bitc.java505_team4.common;

import com.bitc.java505_team4.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ProfilePhotoUtil {public List<UserDto> parseFileInfo(UserDto userInfo, MultipartHttpServletRequest uploadFiles) throws Exception {

    if (ObjectUtils.isEmpty(uploadFiles)) {
        return null;
    }

    List<UserDto> fileList = new ArrayList<UserDto>();

//    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    ZonedDateTime current = ZonedDateTime.now();

//    String path = "C:/upload/" + current.format(format);
    String savedPath = "/profilePhoto";
    // 절대경로로 구현, 변경필요
    String realPath = "C:\\Users\\kaon7\\Desktop\\스프링 팀프로젝트\\java505_team4(2023-07-10 합치기 전)\\java505_team4(회원관련,7월5일기준보드)\\src\\main\\resources\\static\\profilePhoto";

    File file = new File(realPath);

    if (file.exists() == false) {
        file.mkdirs();
    }

    Iterator<String> iterator = uploadFiles.getFileNames();

    String newFileName;
    String originalFileExtension;
    String contentType;

    while (iterator.hasNext()) {
        List<MultipartFile> fileLists = uploadFiles.getFiles(iterator.next());

        for (MultipartFile multipartFile : fileLists) {
            if (multipartFile.isEmpty() == false) {
                contentType = multipartFile.getContentType();

                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                }
                else {
                    if (contentType.contains("image/jpeg")) {
                        originalFileExtension = ".jpg";
                    }
                    else if (contentType.contains("image/png")) {
                        originalFileExtension = ".png";
                    }
                    else if (contentType.contains("image/gif")) {
                        originalFileExtension = ".gif";
                    }
                    else {
                        break;
                    }
                }

                newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

                userInfo.setMemberEmail(userInfo.getMemberEmail());
                userInfo.setMemberProfileName(multipartFile.getOriginalFilename()); // 파일 원본 이름
                userInfo.setMemberProfilePath(savedPath + "/" + newFileName);

//          위에서 생성한 List<BoardFileDto> 타입의 변수에 데이터 추가
                fileList.add(userInfo);

//          자바의 File 클래스 객체를 방금 생성한 파일이름 및 경로로 생성함
                file = new File(realPath + "/" + newFileName);
//          서버의 지정된 위치에 실제 파일을 복사함
                multipartFile.transferTo(file);
            }
        }
    }
//    파일 정보 목록을 반환
    return fileList;
}
}
