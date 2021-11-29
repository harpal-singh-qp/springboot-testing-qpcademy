package com.example.training.springboottesting.mockito;/* harpalsingh created on 11/10/21 inside the package - com.example.training.springboottesting */

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
/**
 * @author Harpal Singh 11/12/21
 */
@Data

@Component
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
