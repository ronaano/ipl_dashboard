import './App.scss';
import {HashRouter as Router, Route } from 'react-router-dom';
import {TeamPage} from "./pages/TeamPage";
import {MatchPage} from "./pages/MatchPage";
import {HomePage} from "./pages/HomePage";

function App() {
  return (
    <div className="App">
        <Router>
                <Route exact path="/teams/:teamName">
                    <TeamPage/>
                </Route>
                <Route path="/teams/:teamName/matches/:year">
                    <MatchPage/>
                </Route>
                <Route path ="/">
                    <HomePage/>
                </Route>
        </Router>
    </div>
  );
}

export default App;
