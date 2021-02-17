import './App.css';
import {BrowserRouter as Router , Route} from 'react-router-dom'
import Login from './components/login/MainLogin';
import Main from './components/main/Main';

const App = ()=>{
  return (
    <Router>
      <Route path="/" exact component={Login} />
      <Route path="/main" exact component={Main} />
    </Router>
  );
}

export default App;
