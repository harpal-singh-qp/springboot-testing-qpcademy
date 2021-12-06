package com.example.training.springboottesting.app.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Harpal Singh 11/12/21
 */
@ExtendWith(MockitoExtension.class)
class TestGetDiscountServiceUsingMock_V3 {

    @Mock
    User user;

    @Mock
    DiscountHelper discountHelper;

    @InjectMocks
    CourseDiscountService courseDiscountService;

    @BeforeEach
    void setup() {
        when(user.isPrimeCustomer()).thenReturn(true);
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