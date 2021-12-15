package com.example.training.springboottesting.app.extentions;

import com.example.training.springboottesting.app.Utility;
import com.example.training.springboottesting.app.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 * CreatedBy Harpal Singh at 12/15/21
 */
public class UserCreatorExtention implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        Parameter parameter = parameterContext.getParameter();

        Type type = parameter.getParameterizedType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (!parameterizedType.getRawType().equals(List.class))
                return false;
            Type firstParameterType = parameterizedType.getActualTypeArguments()[0];
            return firstParameterType.equals(User.class);
        } else return false;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        List<User> userList = new ArrayList<>();
        IntStream.range(1, 5).forEach(i -> createUser(userList));
        return userList;
    }

    private void createUser(List<User> userList) {
        userList.add(new User().setEmailAddress("integration-test-user" + Utility.getRandomInteger()+"@gmail.com")
                .setFirstName("integration")
                .setLastName("user")
                .setPhoneNumber("8867" + Utility.getRandomInteger())
                .setAge(Utility.getRandomAge())
                .setCreatedAt(new Date())
                .setUpdatedAt(new Date()));
    }
}
