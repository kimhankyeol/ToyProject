import axios from 'axios';
const user = {
    login:async(email,password,sns_gb)=>{
        const params={
            "email":email
            ,"password":password
            ,"snsGb":sns_gb
        }
        const res = await asyncFunc.post('http://localhost:8080/login',params);
      //OK , error
        return res;

    },
    snsLogin:async(email,name,sns_gb)=>{
        const params={
            "email":email
            ,"name":name
            ,"snsGb":sns_gb
        }
        const res = await asyncFunc.post('http://localhost:8080/login',params);
        return res;
    }
}

const asyncFunc ={
    get:async(url,params)=>{
        try {
            const response = await axios.get(url,params);
            return response.status === 200 ? response.data : "error";
        } catch (error) {
            return error;
        }
    },
    post:async(url,params)=>{
        try {
            const response = await axios.post(url,params);
            return response.status === 200 ? response.data : "error";
        } catch (error) {
            return error;
        }
    }
}

export default user;