package com.bitc.java505_team4.controller;

import com.bitc.java505_team4.dto.UserDto;
import com.bitc.java505_team4.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String doLogin() throws Exception {
        return "login/loginPage";
    }

    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
//    input태그의 name속성의 불러옴
    public Object doLoginProcess(@RequestParam("memberEmail") String memberEmail, @RequestParam("memberPw") String memberPw, HttpServletRequest req) throws Exception {
        Map<String, String> resultData = new HashMap<>();
        int result = userService.isUserInfo(memberEmail, memberPw);

        if (result == 1) {
            UserDto userInfo = userService.getUserInfo(memberEmail);

            HttpSession session = req.getSession();

            session.setAttribute("memberEmail", userInfo.getMemberEmail());
            session.setAttribute("memberName", userInfo.getMemberName());
//            관리자인지 확인하기 위해서 sql고치고 가져옴
            session.setAttribute("adminYn",userInfo.getAdminYn());
            session.setAttribute("memberProfilePath",userInfo.getMemberProfilePath());

//            hash맵을 사용해서 ajax 사용
            resultData.put("result", "success");
        }else {
            resultData.put("result", "fail");
            resultData.put("message", "로그인에 실패하였습니다.");
        }

        return resultData;
    }

//    main으로 합쳐야함
//    @RequestMapping(value = "/loginOK.do", method = RequestMethod.GET)
//    public ModelAndView doLoginOK(HttpServletRequest req) throws Exception {
//        ModelAndView mv = new ModelAndView("main/mainPage");
//        HttpSession session = req.getSession();
//
//        UserDto user = new UserDto();
//        user.setMemberEmail((String)session.getAttribute("memberEmail"));
//        user.setMemberName((String)session.getAttribute("memberName"));
//        user.setAdminYn((String)session.getAttribute("adminYn"));
//        user.setMemberProfilePath((String)session.getAttribute("memberProfilePath"));
//
//        mv.addObject("userInfo", user);
//
//        return mv;
//    }

    //    세션 삭제를 위한 로그아웃임
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String doLogout(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        session.removeAttribute("memberEmail");
        session.removeAttribute("memberName");
        session.removeAttribute("adminYn");

        session.invalidate();

//        return값을 main page로 이동하게 설정한뒤 제거(현재값 : 임시)
        return "redirect:/main/";
    }

// ------------------------- 내정보 페이지 -------------------------
//    내정보 페이지로 이동
    @RequestMapping(value = "/{memberEmail}", method = RequestMethod.GET)
    public ModelAndView myMemberDetail(@PathVariable("memberEmail") String memberEmail) throws Exception{
        ModelAndView mv = new ModelAndView("login/myPage");

        UserDto user = userService.myUserDetail(memberEmail);
        mv.addObject("userInfo", user);

        return mv;
    }

//    내정보 수정 -> 세션이 원래꺼라서 이미 받아온 세션과 다를수가 있음
//    그래서 세션을 삭제하고 다시 줌 -> html은 history.back하면 새로고침을 눌려야 반영됨
//    jquery에서 location.href로 이동함
@RequestMapping(value = "/{memberEmail}", method = RequestMethod.PUT)
public String doMyUserUpdate(UserDto userInfo, MultipartHttpServletRequest multiPart, HttpServletRequest req) throws Exception{

    HttpSession session = req.getSession();
    session.removeAttribute("memberName");
    session.setAttribute("memberName", userInfo.getMemberName());

    userService.myUserUpdate(userInfo, multiPart);
    return "redirect:/login/{memberEmail}";
}

// ------------------------- 회원가입 페이지 -------------------------
//    회원가입
    @RequestMapping(value = "/joinMembership.do", method = RequestMethod.GET)
    public String doJoinMembership() throws Exception{
        return "login/joinPage";
    }

    @RequestMapping(value = "/joinMembership.do", method = RequestMethod.POST)
    public String resultJoinMembership(UserDto userDto) throws Exception{
        userService.insertMembership(userDto);
        return "login/loginPage";
    }

// -------------------------  회원관리 게시판 페이지 -------------------------
//    회원관리 게시판 페이지
    @RequestMapping(value = "/memberManage.do", method = RequestMethod.GET)
    public ModelAndView doManagement(HttpServletRequest req) throws Exception{
        ModelAndView mv = new ModelAndView("/login/memberManage");

        List<UserDto> userList = userService.selectMemberManage();

        HttpSession session = req.getSession();

//        세션을 가지고 와서 로그인한 아이디의 이름을 보여주기 위해서 사용함
        mv.addObject("userinfo", (String) session.getAttribute("memberName"));
        mv.addObject("userList", userList);
        return mv;
    }

//    @RequestMapping(value = "/memberManage.do", method = RequestMethod.POST)
//    public void doManagement() throws Exception{
//    }

//    application.properties에 PUT, DELETE를 사용하기 위해서 추가해야함
//    # PUT, DELETE도 지원하기 위해서 사용
// spring.mvc.hiddenmethod.filter.enabled=true

// 회원 수정 (관리자를 중간관리자등으로 수정함) - 부가적인 것
    @RequestMapping(value = "/{memberNum}/{adminYn}", method = RequestMethod.PUT)
    public String userUpdate(@PathVariable("memberNum") int memberNum, @PathVariable("adminYn") String adminYn) throws Exception {
        System.out.println(memberNum);

        UserDto user = new UserDto();
        user.setMemberNum(memberNum);
        user.setAdminYn(adminYn);

        userService.updateUser(user);
        return "redirect:/login/memberManage.do";
    }

//    회원 삭제
    @RequestMapping(value = "/{memberNum}", method = RequestMethod.DELETE)
    public String userDelete(@PathVariable("memberNum") int memberNum) throws Exception{
        userService.deleteUser(memberNum);
        return "redirect:/login/memberManage.do";
    }
}






















