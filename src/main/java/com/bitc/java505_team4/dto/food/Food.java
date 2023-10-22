package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "food")
public class Food {
    private String fd_Code;
    private String food_Code;
    private String food_Nm;
    private String fd_Eng_Nm;
    private String nation_Std_Food_Grupp_Code_Nm;
    private String origin_Code_Nm;
    private float food_Wgh;
    private String allrgy_Info;
    private String onslf_Std_Food_Grupp_Nm;
    private String amplt_Cl_Nm;
    private String food_Image_Address;

    @XmlElement
    public String getFd_Code() {
        return fd_Code;
    }

    public void setFd_Code(String fd_Code) {
        this.fd_Code = fd_Code;
    }

    public String getFood_Code() {
        return food_Code;
    }

    public void setFood_Code(String food_Code) {
        this.food_Code = food_Code;
    }

    public String getFood_Nm() {
        return food_Nm;
    }

    public void setFood_Nm(String food_Nm) {
        this.food_Nm = food_Nm;
    }

    public String getFd_Eng_Nm() {
        return fd_Eng_Nm;
    }

    public void setFd_Eng_Nm(String fd_Eng_Nm) {
        this.fd_Eng_Nm = fd_Eng_Nm;
    }

    public String getNation_Std_Food_Grupp_Code_Nm() {
        return nation_Std_Food_Grupp_Code_Nm;
    }

    public void setNation_Std_Food_Grupp_Code_Nm(String nation_Std_Food_Grupp_Code_Nm) {
        this.nation_Std_Food_Grupp_Code_Nm = nation_Std_Food_Grupp_Code_Nm;
    }

    public String getOrigin_Code_Nm() {
        return origin_Code_Nm;
    }

    public void setOrigin_Code_Nm(String origin_Code_Nm) {
        this.origin_Code_Nm = origin_Code_Nm;
    }

    public float getFood_Wgh() {
        return food_Wgh;
    }

    public void setFood_Wgh(float food_Wgh) {
        this.food_Wgh = food_Wgh;
    }

    public String getAllrgy_Info() {
        return allrgy_Info;
    }

    public void setAllrgy_Info(String allrgy_Info) {
        this.allrgy_Info = allrgy_Info;
    }

    public String getOnslf_Std_Food_Grupp_Nm() {
        return onslf_Std_Food_Grupp_Nm;
    }

    public void setOnslf_Std_Food_Grupp_Nm(String onslf_Std_Food_Grupp_Nm) {
        this.onslf_Std_Food_Grupp_Nm = onslf_Std_Food_Grupp_Nm;
    }

    public String getAmplt_Cl_Nm() {
        return amplt_Cl_Nm;
    }

    public void setAmplt_Cl_Nm(String amplt_Cl_Nm) {
        this.amplt_Cl_Nm = amplt_Cl_Nm;
    }

    public String getFood_Image_Address() {
        return food_Image_Address;
    }

    public void setFood_Image_Address(String food_Image_Address) {
        this.food_Image_Address = food_Image_Address;
    }
}
