import react from 'react';
import { Button } from '@material-ui/core';
import { Link } from 'react-router-dom';

const Main = ()=>{
   return (
        <>
            바디
            <Button><Link to="/boardList/1">자유게시판 목록</Link></Button>
            <Button><Link to="/boardList/2">공지사항 목록</Link></Button>
            <Button><Link to="/boardReg/1">게시판 등록</Link></Button>
        </>
   )
}
export default Main;