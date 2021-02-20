import './App.css';
import {BrowserRouter as Router , Route} from 'react-router-dom'
import Login from './components/login/MainLogin';
import Main from './components/main/Main';
import BoardList from './components/board/BoardList';
import BoardReg from './components/board/BoardReg';

const App = ()=>{
  return (
    <Router>
      <Route path="/" exact component={Login} />
      <Route path="/main" exact component={Main} />
      <Route path="/boardList/:boardGubun" exact component={BoardList} />
      <Route path="/boardReg/:boardGubun" exact component={BoardReg} />
    </Router>
  );
}

export default App;
