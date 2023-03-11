
import './App.css';
import Sidebar from './Sidebar'
import Statusbox from './Statusbox'
function App() {
  return (
    <div className="App" >
      
      <div class="sbar">
       <Sidebar></Sidebar>
      </div>
      <div class="content">
    
      <div class = "one"><Statusbox></Statusbox></div> 
      <div class="two"><Statusbox></Statusbox></div> 
       <div class="three"><Statusbox></Statusbox></div> 
     
      </div>
    
      
    </div>
  );
}

export default App;
