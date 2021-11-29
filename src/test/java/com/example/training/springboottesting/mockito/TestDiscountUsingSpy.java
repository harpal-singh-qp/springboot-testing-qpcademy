package com.example.training.springboottesting.mockito;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * @author Harpal Singh 11/12/21
 */
@ExtendWith(MockitoExtension.class)

class TestDiscountUsingSpy {

    @Mock
    User user;


    @Mock
    DiscountHelper discountHelper;

    @Spy
    @InjectMocks
    CourseDiscountService courseDiscountService;


    @Test

    void validateLuckyCustomerDiscount(){
        when(discountHelper.getDiscount(any())).thenReturn(10);
        doReturn(true).when(courseDiscountService).isLuckWinner();
        int actualDiscount = courseDiscountService.getFestiveCourseDiscount("springboot");
        Assertions.assertEquals(60,actualDiscount );
    }

    @Test

    void validateNotLucky_Customer_Discount()  {
        when(discountHelper.getDiscount(any())).thenReturn(10);
        doReturn(false).when(courseDiscountService).isLuckWinner();
        int actualDiscount = courseDiscountService.getFestiveCourseDiscount("springboot");
        Assertions.assertEquals(20,actualDiscount );
    }
}
