package com.bitc.java505_team4.service;

import com.bitc.java505_team4.dto.food.FoodItem;
import com.bitc.java505_team4.dto.food.FoodItems;
import com.bitc.java505_team4.dto.food2.Food2;

import java.util.List;

public interface FoodService {
    FoodItems getItemListUrl(String url) throws Exception;

    List<Food2> getItem2ListUrl(String url) throws Exception;

    List<FoodItem> getItemListUrl2(String url) throws Exception;
}
