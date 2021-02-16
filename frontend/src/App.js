import './App.css';
import {BrowserRouter as Router , Route} from 'react-router-dom'
import Login from './components/login/MainLogin';

const App = ()=>{
  return (
    <Router>
      <Route path="/" exact component={Login} />
    </Router>
  );
}

export default App;
