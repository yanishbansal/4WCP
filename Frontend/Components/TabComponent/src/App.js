import './App.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import Tabs from './Tabs'
import Navbar from './Navbar'

function App() {

  return (
    <div className="App">
      <Navbar></Navbar>
      <Tabs/>
    </div>
  );
}
export default App;
