package com.project.kim.service;

import com.project.kim.domain.User;
import com.project.kim.domain.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("유저")
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Test
    public void signup(){
        //given(준비)
        User user = new User();
        user.setEmail("www@www.ww");
        user.setName("test");
        user.setPassword("1234");
        user.setSnsGb(100);
        //when(실행)
        User result = userService.signup(user);
        //then(결과값 비교)


    }
}