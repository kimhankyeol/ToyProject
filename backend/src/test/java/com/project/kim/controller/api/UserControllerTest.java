package com.project.kim.controller.api;

import com.project.kim.domain.User;
import com.project.kim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
@Slf4j
class UserControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    UserService userService;

    //회원가입
    @Test
    void signup() throws Exception {

        final ResultActions actions =  mvc.perform(MockMvcRequestBuilders.post("/user/signup").param("email","aaa").param("name","bbb"));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("success"));
    }

    @Test
    void test1() throws Exception {
        final ResultActions actions =  mvc.perform(MockMvcRequestBuilders.post("/user/test").param("id","res"));
        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("kim"));
    }
}