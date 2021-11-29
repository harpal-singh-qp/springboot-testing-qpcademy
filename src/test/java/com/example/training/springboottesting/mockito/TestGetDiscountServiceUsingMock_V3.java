package com.example.training.springboottesting.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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