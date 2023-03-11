import React from 'react';
import Axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import "./login.css";
import image from '../Images/img.png'
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme();
export default function Login() {
  const url="http://localhost:8084/api/v1/auth/authenticate" //API for JWT
  const[errMsg,setErrMsg]=useState('');
  const navigate = useNavigate(); 
  const [data, setData] = useState({
    "email":"",
    "password":"" 
  })
     
  function submit(e) {
    e.preventDefault();
    Axios.post(url,{
        "email": data.email, 
        "password": data.password
      },
      { headers:{
          'Access-Control-Allow-Origin':'*'
        }
      }).
      then(res=> {
        localStorage.setItem("token",res.data.token);
        navigate("/home")
      }, 
      (e) => setErrMsg("Invalid Credentials")
  );} 

    function handle(e) {
        const newdata={...data};
        newdata[e.target.id]=e.target.value;
        setData(newdata);
    }
  return (
    <div className='justify-content-center' style={{height:'100vh',backgroudSize: '100px',backgroundImage:`url(${image})`,backgroundRepeat:'no-repeat'}} >
  
    <ThemeProvider theme={theme}  >
    <Container component="main" maxWidth="xs"   >
      <CssBaseline />
      <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', paddingTop:'7rem' }}>
        <Typography component="h1" variant="h5">
          <span style={{fontFamily:'Comic Sans MS' ,fontSize:'2rem'}}>Star App login</span>
        </Typography>
        <Box component="form" onSubmit={(e)=>submit(e)} noValidate sx={{ mt: 3 }}>
          <TextField
            onChange={(e)=>handle(e)}
            margin="normal"
            required
            fullWidth
            id="email"
            label="Email Address"
            name="email"
            autoComplete="email"
            autoFocus
            value={data.email}
            type='email'
          />
          <TextField
            onChange={(e)=>handle(e)}
            margin="normal"
            required
            fullWidth
            name="password"
            label="Password"
            type="password"
            id="password"
            autoComplete="current-password"
            value={data.password}
          />
          <span className='text-danger mt-1'>{errMsg}</span>
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 3, mb: 2 }}>
            Sign In
          </Button>
        </Box>
      </Box>
    </Container>
  </ThemeProvider></div>
  );
}

