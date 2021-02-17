import React from 'react';
import KakaoLogin from 'react-kakao-login';
import { useHistory } from 'react-router-dom';
import user from 'src/lib/common';

const Kakao = ()=>{
    const history = useHistory();
    return (
        <KakaoLogin
            token={process.env.REACT_APP_KAKAO_KEY}
            onSuccess={async(res)=>{
                const loginResult = await user.snsLogin(res.profile.kakao_account.email,res.profile.properties.nickname,1);
                if(loginResult==="ok"){
                    alert(res.profile.properties.nickname+"님 안녕하세요.")
                    history.push("/main");
                }else{
                    alert(loginResult);
                }
            }}
            onFail={console.error}
            onLogout={console.info}
            style={{width:"auto",height:"auto",lineHeight:0,border:0,background:"white"}}
        >
            <img id="kakao-login-btn" alt="카카오 로그인" src="./img/kakao_login.png" style={{width:"100%"}} />
        </KakaoLogin>
    )
}

export default Kakao;