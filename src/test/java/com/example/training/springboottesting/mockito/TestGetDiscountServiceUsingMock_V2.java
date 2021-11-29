package com.example.training.springboottesting.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Harpal Singh 11/12/21
 */
class TestGetDiscountServiceUsingMock_V2 {

    @Mock
    User user;

    @Mock
    DiscountHelper discountHelper;

    CourseDiscountService courseDiscountService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
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