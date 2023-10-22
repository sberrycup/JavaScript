package com.bitc.java505_team4.dto.food2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class Food2Items {
    private List<Food2Item> item2List;

    @XmlElement(name = "item")
    public List<Food2Item> getItem2List() {
        return item2List;
    }

    public void setItem2List(List<Food2Item> item2List) {
        this.item2List = item2List;
    }
}
