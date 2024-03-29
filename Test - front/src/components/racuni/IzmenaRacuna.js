import React, { useCallback, useEffect, useState } from "react";
import TestAxios from "../../apis/TestAxios";
import { useNavigate,useParams } from "react-router-dom";
import{jwtDecode} from 'jwt-decode'
import {Form, Button, Col, Row, Table } from "react-bootstrap";
const IzmenaRacuna=()=>{


    const routeParams=useParams()
    const navigate=useNavigate()

    const [racun,setRacun]=useState([])


    const getRacunById=()=>{
        TestAxios.get("/racuni/"+routeParams.id)
            .then((res)=>{
                console.log(res)
                setRacun(res.data)
            })
            .catch(()=>{
                alert("Nije uspelo dobavljanje")
            })
    }

    useEffect(()=>{
        getRacunById()
    },[])



    const izmeni=(racunId)=>{
        TestAxios.put("/racuni/"+racunId,racun)
            .then((res)=>{
            navigate("/racuni");
          

        })
        .catch((error)=>{
            console.log(error)
            alert("Neuspesna izmena")
        })
    }

    const inputValueChanged=(e)=>{

        let izmenaRacuna={...racun}
        const {name,value}=e.target;
        izmenaRacuna[name]=value;
        setRacun(izmenaRacuna);

    }

    return(
        <Row>
        <Col > 

       
            <Form>

                <Form.Group>
                    <br/>
                    <Form.Label>Ime i prezime</Form.Label>
                    <Form.Control  name="imePrezime" value={racun.imePrezime} onChange={inputValueChanged}></Form.Control>
                </Form.Group>

                <Form.Group>
                    <Form.Label>JMBG</Form.Label>
                    <Form.Control id="zaduzeni" name="jmbg" value={racun.jmbg} onChange={inputValueChanged}></Form.Control>
                </Form.Group>



                <Form.Group>
                    <Form.Label>Broj racuna</Form.Label>
                    <Form.Control   name="brojRacuna"value={racun.brojRacuna} onChange={inputValueChanged}></Form.Control>
                </Form.Group>

                <Form.Group>
                    <Form.Label>Stanje</Form.Label>
                    <Form.Control type="number"  name="stanjeRacuna"  value={racun.stanjeRacuna}onChange={inputValueChanged}></Form.Control>
                </Form.Group>

              

                <br/>
            <Button onClick={()=>izmeni(racun.id)} >Edit</Button>
                <br/>

            </Form>

        </Col>
        </Row>
    )
}

export default IzmenaRacuna