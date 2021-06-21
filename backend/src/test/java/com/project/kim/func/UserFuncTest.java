package com.project.kim.func;

import com.project.kim.func.user.InputCheck;
import com.project.kim.func.user.InputNullCheck;
import com.project.kim.func.user.PasswordStrength;
import com.project.kim.func.user.PasswordStrengthMeter;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserFuncTest {
    //로직은 PasswordStrengthMeter 에서
    private InputNullCheck inp = new InputNullCheck();
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();
    //회원가입
    //INPUT 값
    private void assertInput(String name, String password , String email, InputCheck expStr) {
        InputCheck result = inp.signupCheck(name,password,email);
        assertEquals(expStr, result);
    }
    //비밀번호
    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    //1. 아이디, 비밀번호 ,이메일 입력 되었는지
    @Test
    void InputNullCheck(){
        assertInput("1","12","32", InputCheck.NOTNULL);
    }
    //2. 비밀번호 글자수 8자리 이상
    @Test
    void WordLen8More(){
        assertStrength("12345678", PasswordStrength.STRONG);
    }
    //3. 영어 숫자 포함 되었는지
    @Test
    void WordEngNumInclude(){
        assertStrength("1234a5678", PasswordStrength.STRONG);
    }


}