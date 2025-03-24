package com.example.ut_demo;

import com.example.ut_demo.api.mapper.UserMapper;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

@MybatisTest
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;
}
