package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.dto.UserRankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositorySearchImpl implements UserRepositorySearch {

    private final EntityManager entityManager;


    public List<UserRankDto> findYoungest() {
        List<Object[]> resultList = entityManager
                .createNativeQuery("SELECT  first_name, age,  @curRank\\:=@curRank + 1 AS rank FROM  " +
                        "user p, (SELECT @curRank\\:=0) r ORDER BY  age").getResultList();
        return resultList.stream().map(this::convertToRankDTO).collect(Collectors.toList());


    }

    private UserRankDto convertToRankDTO(Object[] row) {
        return UserRankDto.builder().firstName(row[0].toString()).age(String.valueOf(row[1])).rank(row[2].toString())
                .build();
    }
}