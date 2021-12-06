package com.example.training.springboottesting.app.mockito;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Harpal Singh 11/12/21
 */
@Service
@Slf4j
public class CourseDiscountService {

    private DiscountHelper discountHelper;

    private User user;

    CourseDiscountService(DiscountHelper discountHelper, User user){
        this.discountHelper = discountHelper;
        this.user = user;
    }

    @Value("${course.name.not.valid}")
    private String courseNameNotValid;



    public int getFestiveCourseDiscount(String courseName) {
        int discount = discountHelper.getDiscount(courseName);
        if (isLuckWinner()) {
            discount = 50+discount;
        } else {
            discount = discount + 10;
        }
        return discount;
    }

      boolean isLuckWinner() {
          /// third party api call
         // somecomplex logic
         // /////business logic
        return new Random().nextBoolean();
    }

    public int getCourseDiscount(String courseName) throws CourseNotFoundException {
        if (courseName == null) {
            throw new CourseNotFoundException(courseNameNotValid);
        } else if (courseName.length() < 3) {
            throw new IllegalArgumentException("CourseName is too short");
        } else if (courseName.length() > 30) {
            throw new IllegalArgumentException("CourseName is too long");
        }
        Integer discount = discountHelper.getDiscount(courseName);
        if (user.isPrimeCustomer()) {
            return discount + 20;
        }
        return discount;
    }

}