package com.example.training.springboottesting;/* harpalsingh created on 11/10/21 inside the package - com.example.training.springboottesting */

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;
/**
 * @author Harpal Singh 11/12/21
 */
@Data
@Builder
public  class DiscountHelper {

    private String courseName;

    private int discount;

    private Map<String,Integer> couponCodeDiscountMap;

    private List<String> festiveMonths;

    private Course course;


    public int getDiscount(String courseName){
        return couponCodeDiscountMap.get(courseName);
    }
}
