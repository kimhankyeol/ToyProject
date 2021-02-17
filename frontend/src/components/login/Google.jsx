import React from 'react'
import { GoogleLogin } from 'react-google-login';
import { useHistory } from 'react-router-dom';
import user from 'src/lib/common';

const Google = ()=>{
    const history = useHistory();
    return (
            <GoogleLogin
            clientId={process.env.REACT_APP_GOOGLE_CLIENTID}
            onSuccess={async(res)=>{
                const loginResult = await user.snsLogin(res.profileObj.email,res.profileObj.name,2);
                if(loginResult==="ok"){
                    alert(res.profileObj.name+"님 안녕하세요.");
                    history.push("/main");
                }else{
                    alert(loginResult);
                }
            }}
            onFailure={(err)=>{
                console.log(err);
            }}
            >
            </GoogleLogin>
        );
}
export default Google