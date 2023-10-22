package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class FoodItems {
    private List<FoodItem> itemList;
    private Integer totalPage;

    public FoodItems() {
        // 기본 생성자
    }

    public FoodItems(List<FoodItem> itemList, Integer totalPage) {
        this.itemList = itemList;
        this.totalPage = totalPage;
    }

    @XmlElement(name = "item")
    public List<FoodItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<FoodItem> itemList) {
        this.itemList = itemList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
