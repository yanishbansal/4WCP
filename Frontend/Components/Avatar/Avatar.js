import Dropdown from 'react-bootstrap/Dropdown';
function AvatarDropDown() {
  return (
    <Dropdown id='avatarlogo' >
      <Dropdown.Toggle variant="light" id="dropdown-basic">
      <img height="35px" width="35px" src='https://png.pngtree.com/png-vector/20220817/ourmid/pngtree-cartoon-man-avatar-vector-ilustration-png-image_6111064.png'></img>
      </Dropdown.Toggle>

      <Dropdown.Menu class = "menu">
        <Dropdown.Item href="#/action-3" >Logout</Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown>
  );
}

export default AvatarDropDown;