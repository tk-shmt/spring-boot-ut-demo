package com.example.ut_demo;

import com.example.ut_demo.api.mapper.UserMapper;
import com.example.ut_demo.api.model.User;
import com.example.ut_demo.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1);
        user.setName("testUser");
        user.setEmail("test@email.com");
    }

    @Test
    void getUserTest_ExistUser() {
        doReturn(user).when(userMapper).findById(1);
        assertEquals(user, userService.getUser(1));
    }

    @Test
    void getUserTest_NoExistUser() {
        doReturn(null).when(userMapper).findById(0);
        assertNull(userService.getUser(0));
    }

    @Test
    void createUserTest_Success() {
        doReturn(1).when(userMapper).insert(user);
        assertEquals(user, userService.createUser(user));
    }

}
