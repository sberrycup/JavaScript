package com.bitc.java505_team4.controller;

import com.bitc.java505_team4.dto.UserDto;
import com.bitc.java505_team4.dto.food.FoodItems;
import com.bitc.java505_team4.dto.food2.Food2;
import com.bitc.java505_team4.service.FoodService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/foodUrl")
    public ModelAndView getFoodUrl(HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("food/foodInfoPage");

        HttpSession session = req.getSession();

        UserDto user = new UserDto();
        user.setMemberEmail((String)session.getAttribute("memberEmail"));
        user.setMemberName((String)session.getAttribute("memberName"));
        user.setAdminYn((String)session.getAttribute("adminYn"));
        user.setMemberProfilePath((String)session.getAttribute("memberProfilePath"));

        mv.addObject("userInfo", user);

        return mv;
    }

    @GetMapping("/foodDiet")
    public ModelAndView getFoodDiet(HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("food/foodDiet");

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
@PostMapping("/foodUrl")
public FoodItems getFoodUrl(String Page_No, String Page_Size, String fd_Nm) throws Exception {
    String url = "http://apis.data.go.kr/1390802/AgriFood/FdFoodImage/getKoreanFoodFdFoodImageList";
    String serviceKey = "?serviceKey=";
    String key = "V6sOU5lJPVHWK%2B8WWk6O3%2Fctk7SrcYPUMUHx%2BBVDTE6uYsBzGnc01i7SWJBK9z5Z3AeDc%2F6a1DyINynN3Ez09g%3D%3D";
    String serviceType = "&service_Type=xml";
    String opt1 = "&Page_No=";
    String opt2 = "&Page_Size=";
    String opt3 = "&food_Name=";
    fd_Nm = URLEncoder.encode(fd_Nm, "UTF-8");

    FoodItems foodItems = foodService.getItemListUrl(url + serviceKey + key + serviceType + opt1 + Page_No + opt2 + Page_Size + opt3 + fd_Nm);
    return foodItems;
}



    @ResponseBody
    @PostMapping("/foodUrl2")
    public Object getFood2Url(@RequestParam("foodCd[]") String[] foodCd) throws Exception {
        String url = "http://apis.data.go.kr/1390802/AgriFood/MzenFoodNutri/getKoreanFoodIdntList";
        String serviceKey = "?serviceKey=";
        String key = "V6sOU5lJPVHWK%2B8WWk6O3%2Fctk7SrcYPUMUHx%2BBVDTE6uYsBzGnc01i7SWJBK9z5Z3AeDc%2F6a1DyINynN3Ez09g%3D%3D";
        String opt1 = "&food_Code=";

        List<List<Food2>>item2List = new ArrayList<>();

        for (int i = 0; i < foodCd.length; i++) {
            List<Food2> food2 = foodService.getItem2ListUrl(url + serviceKey + key + opt1 + foodCd[i]);
            if (food2 != null) {
                item2List.add(food2);
            }
        }
        return item2List;
    }

    @ResponseBody
    @PostMapping("/foodUrl3")
    public Object getFood2Url(String foodCd) throws Exception {
        String url = "http://apis.data.go.kr/1390802/AgriFood/MzenFoodNutri/getKoreanFoodIdntList";
        String serviceKey = "?serviceKey=";
        String key = "0m0EyVE7TywORA8Zu4qti6NOPFYY6D89BGTNGTz7%2BT4uU6Cp%2B8fCsQDYypUZD5ML4Q%2BwGxBsnH2lJg0yD2Ei9g%3D%3D";
        String opt1 = "&food_Code=";

        List<Food2>item2List = foodService.getItem2ListUrl(url + serviceKey + key + opt1 + foodCd);

        return item2List;
    }
}
