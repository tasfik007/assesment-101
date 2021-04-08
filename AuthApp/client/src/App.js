import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Login from './components/layout/Login';
import Register from './components/layout/Register';
import Profile from './components/layout/Profile';
import Error from './components/layout/Error';


function App() {
  return (
    <Router>
      <Route exact path="/" component={Login} />
      <Route exact path="/register" component={Register} />
      <Route exact path="/profile" component={Profile} />
      <Route exact path="/error" component={Error} />
    </Router>

  );
}

export default App;
