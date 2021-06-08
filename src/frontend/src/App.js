import './App.scss';
import {BrowserRouter as Router, Route } from 'react-router-dom';
import {TeamPage} from "./pages/TeamPage";
import {MatchPage} from "./pages/MatchPage";

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
        </Router>
    </div>
  );
}

export default App;
