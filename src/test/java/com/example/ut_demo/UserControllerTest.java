package com.example.ut_demo;

import com.example.ut_demo.api.model.User;
import com.example.ut_demo.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1);
        user.setName("testUser");
        user.setEmail("test@email.com");
    }

    @Test
    @DisplayName("getメソッドの確認")
    public void getUserTest() throws Exception {
        // モックオブジェクトuserServiceのgetUserメソッドの挙動をシミュレート
        doReturn(user).when(userService).getUser(1);
        // 結果の評価
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("testUser"));
    }

    @Test
    @DisplayName("createメソッドの確認")
    public void createUserTest() throws Exception {
        // モックオブジェクトuserServiceのcreateUserメソッドの挙動をシミュレート
        doReturn(user).when(userService).createUser(any(User.class));
        String json = objectMapper.writeValueAsString(user);
        // 結果の評価
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}
