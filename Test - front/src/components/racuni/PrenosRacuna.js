import React, {  useEffect, useState } from "react";
import TestAxios from "../../apis/TestAxios";
import {Form, Button, Col, Row } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";


const PrenosRacuna=()=>{

    const [params,setParams]=useState([])
    const navigate=useNavigate();
    const inputValueChanged=(e)=>{
        const {name,value}=e.target;
        setParams({...params,[name]:value})
        console.log({name,value})
    }

    const prenesi=()=>{
        TestAxios.get("/racuni/prenos",{
           
              params:{ racunUplatioca:params.racunUplatioca,
                racunPrimaoca:params.racunPrimaoca,
                iznos:params.iznos  
              }
        })
        .then((res)=>{
            console.log(res)
            navigate("/racuni")
        })
        .catch(()=>{
            alert("Neuspesan prenos !")
        })
    }


    return(
        <Row>
                <Row><h1>Nalog za prenos</h1></Row>


                <Col>
       <Form>

           <Form.Group>
               <Form.Label> Broj racuna uplatioca </Form.Label>
               <Form.Control name="racunUplatioca" onChange={inputValueChanged} />
           </Form.Group>

           <Form.Group>
               <Form.Label> Broj racuna primaoca </Form.Label>
               <Form.Control  name="racunPrimaoca"onChange={inputValueChanged} />
           </Form.Group>

           <Form.Group>
               <Form.Label> Iznos </Form.Label>
               <Form.Control type="number" name="iznos" onChange={inputValueChanged} />
           </Form.Group>

    
        
           <br/>
           <Button onClick={()=>prenesi()}>Prenesi</Button>

       </Form>
       </Col>

        </Row>
     
    )
}

export default PrenosRacuna;