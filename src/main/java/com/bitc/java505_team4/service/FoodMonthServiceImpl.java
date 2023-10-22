package com.bitc.java505_team4.service;


import com.bitc.java505_team4.dto.FoodMonthDto;
import com.bitc.java505_team4.mapper.FoodMonthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodMonthServiceImpl implements FoodMonthService {

    @Autowired
    FoodMonthMapper foodMonthMapper;

//    @Override
//    public List<FoodMonthDto> foodMonthList(String foodMName, String foodMMonth) throws Exception {
//        return foodMonthMapper.foodMonthList(foodMName, foodMMonth);
//    }

//    전체 검색
    @Override
    public List<FoodMonthDto> foodMonthList(String foodMName) throws Exception {
        return foodMonthMapper.foodMonthList(foodMName);
    }

    @Override
    public List<FoodMonthDto> foodNameNullMonthList(String foodMMonth) throws Exception {
        return foodMonthMapper.foodNameNullMonthList(foodMMonth);
    }
}
