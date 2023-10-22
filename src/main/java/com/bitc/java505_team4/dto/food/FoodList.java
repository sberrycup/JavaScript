package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "food_List")
public class FoodList {
    private List<Food> foodList;

    @XmlElement(name = "food")
    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
