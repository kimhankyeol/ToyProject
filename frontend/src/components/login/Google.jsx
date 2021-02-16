import React from 'react'
import { GoogleLogin } from 'react-google-login';
import user from 'src/lib/common';

const Google = ()=>{
    return (
            <GoogleLogin
            clientId={process.env.REACT_APP_GOOGLE_CLIENTID}
            onSuccess={(res)=>{
                user.snsLogin(res.profileObj.email,res.profileObj.name,2);
            }}
            onFailure={(err)=>{
                console.log(err);
            }}
            >
            </GoogleLogin>
        );
}
export default Google