import react from 'react';
import { useState } from 'react';
import { Button } from '@material-ui/core';
import { useHistory } from 'react-router-dom';
import { useEffect } from 'react';
const BoardList = ({match})=>{
    console.log(match)
    const {boardGubun} = match.params; 

    const [number,setNumber] = useState(boardGubun);
    const history = useHistory();
    //[] 값없으면 
    // useEffect(()=>{
    //     if(number==='1'){
    //         history.push('/boardList/2')
    //     }else{
    //         history.push('/boardList/1')
    //     }
    // },[] ) 
    useEffect(()=>{
        if(number==='1'){
            history.push('/boardList/2')
        }else{
            history.push('/boardList/1')
        }

    },[number] ) 

    console.log(boardGubun)
    let view ="";
    let arr = new Object;

    if(number === '1'){
            //ajax 
        view = "자유게시판"
        arr=  [
            {"content":'김한결'},{"content":'김한결2'},{"content":'김한결3'}
        ]
    }else{
        view = "공지사항"
        arr=  [
            {"content":'유'},{"content":'유2'},{"content":'유3'}
        ]
    }
    // if(boardGubun === '1'){
    //        //ajax 
    //     view = "자유게시판"
    //     arr=  [
    //         {"content":'김한결'},{"content":'김한결2'},{"content":'김한결3'}
    //     ]
    // }else{
    //     view = "공지사항"
    //     arr=  [
    //         {"content":'유'},{"content":'유2'},{"content":'유3'}
    //     ]
    // }
 

    return (
        <>
        {view}
        리스트화면
        {arr.map(res =>{
            return (
                <div>{res.content}</div>
            )
        })}
        <Button onClick={()=>{
            number === '1' ? setNumber('2'):setNumber('1')
        }}>변환</Button>
        </>
    )
}
export default BoardList;