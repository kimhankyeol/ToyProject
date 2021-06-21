package com.project.kim.func.user;


public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        //1.값이 없음
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        //2. 8자리 이상
        if (s.length() < 8) {
            return PasswordStrength.WEAK;
        }
        //3. 영 숫자 포함
        if(!engNumInclude(s)){
            return PasswordStrength.WEAK;
        }

        return PasswordStrength.STRONG;
    }
    //3. 영 숫자 포함
    private boolean engNumInclude(String s){
        int numCount =0 , engCount = 0;
        for (char ch : s.toCharArray()) {
            if(numCount>0  && engCount>0 && numCount+engCount >=2)
                return true;
            if (ch >= '0' && ch <= '9') {
                numCount++;
            }else if(ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122){
                engCount++;
            }
        }
        return false;
    }


}
