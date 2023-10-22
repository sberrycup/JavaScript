package com.bitc.java505_team4.dto.food2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "item")
public class Food2Item {
    private String main_Food_Code;
    private String main_Food_Name;
    private List<Food2> food2List;

    @XmlElement
    public String getMain_Food_Code() {
        return main_Food_Code;
    }

    public void setMain_Food_Code(String main_Food_Code) {
        this.main_Food_Code = main_Food_Code;
    }

    public String getMain_Food_Name() {
        return main_Food_Name;
    }

    public void setMain_Food_Name(String main_Food_Name) {
        this.main_Food_Name = main_Food_Name;
    }

    @XmlElement(name = "idnt_List")
    public List<Food2> getFood2List() {
        return food2List;
    }

    public void setFood2List(List<Food2> food2List) {
        this.food2List = food2List;
    }
}
