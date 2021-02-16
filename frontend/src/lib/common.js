import axios from 'axios';
const user = {
    login:(email,password,sns_gb)=>{
        const params={
            "email":email
            ,"password":password
            ,"snsGb":sns_gb
        }
        asyncFunc.post('http://localhost:8080/login',params);
    },
    snsLogin:(email,name,sns_gb)=>{
        const params={
            "email":email
            ,"name":name
            ,"snsGb":sns_gb
        }
        asyncFunc.post('http://localhost:8080/login',params);
    }
}

const asyncFunc ={
    get:(url,params)=>{
        axios.get(url,params).then(res =>{
            console.log(res)
        })
    },
    post:(url,params)=>{
        axios.post(url,params).then(res =>{
            console.log(res)
        })
    }
}

export default user;