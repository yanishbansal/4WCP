import React from 'react'
import { Grid,Paper, Avatar, TextField, Button, Typography,Link, Input } from '@material-ui/core'
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Axios from 'axios'
import { useState } from 'react';
const Login=()=>{

    const paperStyle={padding :20,height:'70vh',width:280, margin:"20px auto", }
    const avatarStyle={backgroundColor:'#1bbd7e'}
    const btnstyle={margin:'8px 0'}
    const GridStyle={backgroundColor:'Blue'}
    const url="https://localhost:7286/api/Login/Authorize" //API for JWT

    const [data,setData]=useState({
        username:"",
        password:""
 })


    function submit(e)
    {
    e.preventDefault();
     Axios.post(url,{
      username: data.username,
      password: data.password
    }).then(res=> {
       console.log("JWT token" )
       alert(" Logged In Successfully ")
       console.log(res.data)
    }, 
        
        e=> console.error(e)
    );

   
     
   
      
    } 
    
    


    
    
    function handle(e)
    {
        const newdata={...data};
        newdata[e.target.id]=e.target.value;
        setData(newdata);
        // console.log(newdata);

    }


    return(
       
        <Grid style={GridStyle}>
            <div >
            <Paper elevation={10} style={paperStyle}>
                <Grid align='center'>
                     <Avatar style={avatarStyle}><LockOutlinedIcon/></Avatar>
                    <h2>Login Incedo</h2>
                </Grid>
                <form onSubmit={ (e) => submit(e) }>
            
                <Input onChange={(e)=>handle(e)}  id="username" value={data.username} label='Incedo-Id'  placeholder='Enter IncedoId' fullWidth required/>
            
                <Input onChange={(e)=>handle(e)} label='Password' value={data.password} id="password"  placeholder='Enter Password' type='password' fullWidth required/>
                
                <Button type='submit' color='primary' variant="contained" style={btnstyle} fullWidth>Sign in</Button>
                </form>

                <Typography >
                     <Link href="#" >
                        Forgot password ?
                     </Link>
                </Typography>
               
               
            </Paper>
            </div>
        </Grid>
    )

    }
export default Login