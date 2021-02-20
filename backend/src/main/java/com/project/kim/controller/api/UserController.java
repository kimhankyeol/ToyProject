package com.project.kim.controller.api;

import com.project.kim.domain.User;
import com.project.kim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/kim")
    public List<String> kim(){
        List<String> kim = new ArrayList<>();
        kim.add("asd");
        return kim;
    }
}
