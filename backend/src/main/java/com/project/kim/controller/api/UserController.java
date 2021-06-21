package com.project.kim.controller.api;

import com.project.kim.domain.User;
import com.project.kim.func.CmmUtil;
import com.project.kim.func.user.InputCheck;
import com.project.kim.func.user.InputNullCheck;
import com.project.kim.func.user.PasswordStrength;
import com.project.kim.func.user.PasswordStrengthMeter;
import com.project.kim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/signup")
    public ResponseEntity<String> signup(@ModelAttribute User user){
        //입력값 체크
        InputNullCheck inputNullCheck = new InputNullCheck();
        InputCheck inpResult = inputNullCheck.signupCheck(CmmUtil.nvl(user.getName()),CmmUtil.nvl(user.getPassword()),CmmUtil.nvl(user.getEmail()));
        if(inpResult == InputCheck.NOTNULL){
            //비밀번호 체크
            PasswordStrengthMeter meter = new PasswordStrengthMeter();
            PasswordStrength pwdResult = meter.meter(CmmUtil.nvl(user.getPassword()));
            if(pwdResult == PasswordStrength.WEAK){
                return new ResponseEntity<String>(pwdResult.toString(),HttpStatus.OK);
            }
            //성공
            userService.signup(user);
            return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
        }
        return new ResponseEntity<String>(inpResult.toString(),HttpStatus.OK);
    }

    @PostMapping(value="test")
    public ResponseEntity<String> test(@RequestParam(value = "id") String id) {
        return new ResponseEntity<String>(id,HttpStatus.OK);
    }
}
