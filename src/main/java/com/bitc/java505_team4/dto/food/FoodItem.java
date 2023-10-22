package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class FoodItem {
    private String no;
    private String fd_Code;
    private String upper_Fd_Grupp_Nm;
    private String fd_Grupp_Nm;
    private String fd_Nm;
    private float fd_Wgh;
    private String food_Cnt;
    private String image_Address;
    private FoodList foodList;
    private String ckry_Nm;
    private String ckry_Sumry_Info;


//    private int total_count;

    @XmlElement
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getFd_Code() {
        return fd_Code;
    }

    public void setFd_Code(String fd_Code) {
        this.fd_Code = fd_Code;
    }

    public String getUpper_Fd_Grupp_Nm() {
        return upper_Fd_Grupp_Nm;
    }

    public void setUpper_Fd_Grupp_Nm(String upper_Fd_Grupp_Nm) {
        this.upper_Fd_Grupp_Nm = upper_Fd_Grupp_Nm;
    }

    public String getFd_Grupp_Nm() {
        return fd_Grupp_Nm;
    }

    public void setFd_Grupp_Nm(String fd_Grupp_Nm) {
        this.fd_Grupp_Nm = fd_Grupp_Nm;
    }

    public String getFd_Nm() {
        return fd_Nm;
    }

    public void setFd_Nm(String fd_Nm) {
        this.fd_Nm = fd_Nm;
    }

    public float getFd_Wgh() {
        return fd_Wgh;
    }

    public void setFd_Wgh(float fd_Wgh) {
        this.fd_Wgh = fd_Wgh;
    }

    public String getFood_Cnt() {
        return food_Cnt;
    }

    public void setFood_Cnt(String food_Cnt) {
        this.food_Cnt = food_Cnt;
    }

    public String getImage_Address() {
        return image_Address;
    }

    public void setImage_Address(String image_Address) {
        this.image_Address = image_Address;
    }

    //    public int getTotal_count() {
//        return total_count;
//    }
//
//    public void setTotal_count(int total_count) {
//        this.total_count = total_count;
//    }
    public String getCkry_Nm() {
        return ckry_Nm;
    }

    public void setCkry_Nm(String ckry_Nm) {
        this.ckry_Nm = ckry_Nm;
    }

    public String getCkry_Sumry_Info() {
        return ckry_Sumry_Info;
    }

    public void setCkry_Sumry_Info(String ckry_Sumry_Info) {
        this.ckry_Sumry_Info = ckry_Sumry_Info;
    }

    @XmlElement(name = "food_List")
    public FoodList getFoodList() {
        return foodList;
    }

    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }
}
