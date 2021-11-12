package com.example.training.springboottesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

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
        courseDiscountService = new CourseDiscountService(discountHelper, user);
    }

    @Test
    void validatePrimeCustomerDiscount() {
        when(user.isPrimeCustomer()).thenReturn(true);
        when(discountHelper.getDiscount(anyString())).thenReturn(10);
        int discount = courseDiscountService.getCourseDiscount("springboot");
        assertEquals(30, discount);
    }

    @Test
    void validateNonPrimeCustomerDiscount() {
        when(user.isPrimeCustomer()).thenReturn(false);
        when(discountHelper.getDiscount(anyString())).thenReturn(10);
        int discount = courseDiscountService.getCourseDiscount("springboot");
        assertEquals(10, discount);
    }
}