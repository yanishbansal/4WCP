import React ,{useEffect,useState}from 'react';
import { useNavigate } from 'react-router';
import { DropdownItem, DropdownToggle, DropdownMenu} from 'reactstrap';
import { UncontrolledDropdown } from 'reactstrap';
import './Logout.css';

function clearLocalStorage(nav) {
    localStorage.removeItem("token");
    nav('/login');

}
function Logout({resouceName}) {
    const navigate = new useNavigate();
    return (
        <div style={{backgroundColor:'#212529'}}>
            <UncontrolledDropdown className='lout' style={{backgroundColor:'#212529'}}>
                <DropdownToggle class="text-dark" style={{backgroundColor:'#212529'}}><div class="text-white">{resouceName}</div>
                </DropdownToggle>
                <DropdownMenu>
                    <DropdownItem onClick={(nav)=>clearLocalStorage(navigate)}>
                        Logout
                    </DropdownItem>
                </DropdownMenu>
            </UncontrolledDropdown>
        </div>
    );
}

export default Logout;