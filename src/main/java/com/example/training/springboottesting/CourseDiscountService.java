package com.example.training.springboottesting;

/**
 * @author Harpal Singh 11/12/21
 */
public class CourseDiscountService {

    private DiscountHelper discountHelper;

    private User user;

    CourseDiscountService(DiscountHelper discountHelper , User user){
        this.discountHelper = discountHelper;
        this.user = user;
    }

    public int getCourseDiscount(String courseName)  {
        Integer discount = discountHelper.getDiscount(courseName);
        if(user.isPrimeCustomer()){
            return discount+20;
        }
        return discount;
    }





}

