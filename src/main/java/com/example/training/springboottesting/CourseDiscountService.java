package com.example.training.springboottesting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * @author Harpal Singh 11/12/21
 */
///@PropertySource("classpath:aws/aws-config.properties")
@Service
@Slf4j
public class CourseDiscountService {

    private DiscountHelper discountHelper;


    private User user;

    @Value("${course.name.not.valid}")
    String courseNameNotValid;

    CourseDiscountService(DiscountHelper discountHelper , User user){
        this.discountHelper = discountHelper;
        this.user = user;
    }

    public int getCourseDiscount(String courseName) throws CourseNotFoundException {
        if(courseName==null){
            throw new CourseNotFoundException(courseNameNotValid);
        } else if(courseName.length()<3){
            throw new IllegalArgumentException("CourseName is too short");
        }else if(courseName.length()>30){
            throw new IllegalArgumentException("CourseName is too long");
        }
        Integer discount = discountHelper.getDiscount(courseName);
        if(user.isPrimeCustomer()){
            return discount+20;
        }
        return discount;
    }



}

