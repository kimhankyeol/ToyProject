package com.project.kim.func.user;

public class InputNullCheck {

    public InputCheck signupCheck(String name , String password, String email){
        if(name.equals("")){
            return InputCheck.NAMENULL;
        }else if(password.equals("")){
            return InputCheck.PASSWORDNULL;
        }else if(email.equals("")){
            return InputCheck.EMAILNULL;
        }
        return  InputCheck.NOTNULL;
    }
}
