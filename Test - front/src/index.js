import React from 'react';
import { createRoot } from 'react-dom/client';
import {Link, Route,BrowserRouter as Router, Routes} from 'react-router-dom';
import Home from './components/Home';
import NotFound from './components/NotFound';
import Login from './components/authorization/Login';
import { logout } from './services/auth';
import { Button, Nav, Navbar, NavbarBrand ,Container} from 'react-bootstrap';
import Racun from './components/racuni/Racun';
import IzmenaRacuna from './components/racuni/IzmenaRacuna';
import PrenosRacuna from './components/racuni/PrenosRacuna';

 
 

const App = () => {

    if(window.localStorage['jwt']){
        return( 
        
                <Router>

                <Navbar expand bg="dark" variant='dark'>   

                    <NavbarBrand as={Link} to="/"> JWD </NavbarBrand>  
                    <NavbarBrand as={Link} to="/racuni"> Racun </NavbarBrand> 


                    <Nav>
                        <Button onClick={()=>logout()} >Logout</Button>
                    </Nav>
                </Navbar>
    
    		<Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path='/' element={<Home/>} />      
                    <Route path='/racuni' element={<Racun/>} />
                    <Route path='/racuni/izmena/:id' element={<IzmenaRacuna/>} />
                    <Route path='/login' element={<Login/>} />
                    <Route path='/racuni/prenos' element={<PrenosRacuna/>} />
                    <Route path='*'  element={<NotFound/>}/>
                </Routes>
                </Container>
                </Router>
    
    
        )
    }else{
        return( 
          
                <Router>

                <Navbar expand bg="dark" variant='dark'> 
                     <NavbarBrand as={Link} to="/"> JWD </NavbarBrand>     
                     <NavbarBrand as={Link} to="/racuni"> Racun </NavbarBrand>   
                  
                     <Nav.Link as={Link} to="/login" >Login</Nav.Link>
                </Navbar>
                
    		<Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path='/' element={<Home/>} />      
                    <Route path='/racuni' element={<Racun/>} />
                    <Route path='/racuni/izmena/:id' element={<IzmenaRacuna/>} />  
                    <Route path='/racuni/prenos' element={<PrenosRacuna/>} /> 
                    <Route path='/login' element={<Login/>} />
                    <Route path='*'  element={<NotFound/>}/>
                </Routes>
  		</Container>
                </Router>
    
    
        
    
        )
    }

    

};


const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App />,
);
 
