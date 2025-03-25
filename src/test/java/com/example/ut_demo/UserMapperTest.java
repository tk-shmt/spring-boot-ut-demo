package com.example.ut_demo;

import com.example.ut_demo.api.mapper.UserMapper;
import com.example.ut_demo.api.model.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@Sql("classpath:/sql/schema.sql")
@Sql("classpath:/sql/test-data.sql")
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void findByIdTest() {
        // テストデータ準備
        int userId = 1;
        User expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setName("testUser");
        expectedUser.setEmail("test@email.com");
        // テスト実行
        User actualUser = mapper.findById(userId);
        // 結果の検証
        assertEquals(expectedUser,actualUser);
    }
}
