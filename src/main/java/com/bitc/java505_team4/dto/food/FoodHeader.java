package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "header")
public class FoodHeader {
    private String result_Code;
    private String result_Msg;

    @XmlElement
    public String getResult_Code() {
        return result_Code;
    }

    public void setResult_Code(String result_Code) {
        this.result_Code = result_Code;
    }

    public String getResult_Msg() {
        return result_Msg;
    }

    public void setResult_Msg(String result_Msg) {
        this.result_Msg = result_Msg;
    }
}
