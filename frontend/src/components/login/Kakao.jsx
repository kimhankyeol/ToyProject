import React from 'react';
import KakaoLogin from 'react-kakao-login';
import user from 'src/lib/common';

const Kakao = ()=>{
    return (
        <KakaoLogin
            token={process.env.REACT_APP_KAKAO_KEY}
            onSuccess={(res)=>{
                user.snsLogin(res.profile.kakao_account.email,res.profile.properties.nickname,1)
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