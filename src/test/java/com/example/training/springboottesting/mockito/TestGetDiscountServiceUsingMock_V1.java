package com.example.training.springboottesting.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Harpal Singh 11/12/21
 */
class TestGetDiscountServiceUsingMock_V1 {

    User user;

    DiscountHelper discountHelper;

    CourseDiscountService courseDiscountService;

    @BeforeEach
    void setup() {
        user = Mockito.mock(User.class);
        discountHelper = Mockito.mock(DiscountHelper.class);
        courseDiscountService = new CourseDiscountService(discountHelper,user);
    }

    @Test
    void validatePrimeCustomerDiscount() throws CourseNotFoundException {
        when(user.isPrimeCustomer()).thenReturn(true);
        when(discountHelper.getDiscount(anyString())).thenReturn(10);
        int discount = courseDiscountService.getCourseDiscount("springboot");
        assertEquals(30, discount);
    }

    @Test
    void validateNonPrimeCustomerDiscount() throws CourseNotFoundException {
        when(user.isPrimeCustomer()).thenReturn(false);
        when(discountHelper.getDiscount(anyString())).thenReturn(10);
        int discount = courseDiscountService.getCourseDiscount("springboot");
        assertEquals(10, discount);
    }
}