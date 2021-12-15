package com.example.training.springboottesting.app.mockito;

import com.example.training.springboottesting.app.logging.CustomLoggingTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Harpal Singh 11/12/21
 */
@ExtendWith(MockitoExtension.class)
class TestGetDiscountServiceUsingMock_V3 {


    private static Log log = LogFactory.getLog(TestGetDiscountServiceUsingMock_V3.class);

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
        log.info("");
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