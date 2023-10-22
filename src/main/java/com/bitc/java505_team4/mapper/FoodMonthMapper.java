package com.bitc.java505_team4.mapper;


import com.bitc.java505_team4.dto.FoodMonthDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodMonthMapper {
//    List<FoodMonthDto> foodMonthList(@Param("foodMName") String foodName, @Param("foodMMonth") String month) throws Exception;
    List<FoodMonthDto> foodMonthList(@Param("foodMName") String foodName) throws Exception;
    List<FoodMonthDto> foodNameNullMonthList(@Param("foodMMonth") String month) throws Exception;
}
