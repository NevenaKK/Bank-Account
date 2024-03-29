import React, { useCallback, useEffect, useState } from "react";
import TestAxios from "../../apis/TestAxios";
import { useNavigate } from "react-router-dom";
import{jwtDecode} from 'jwt-decode'
import {Form, Button, Col, Row, Table } from "react-bootstrap";



const Racun=()=>{

    const token=window.localStorage.getItem("jwt")
    const decoded=token?jwtDecode(token):null
    const isAdmin=decoded?.role?.authority==="ROLE_ADMIN"


    const [pageNo,setPageNo]=useState(0);
    const [pageMax,setPageMax]=useState(0);

    const [banke,setBanke]=useState([]);
    const [searchParams,setSearchParams]=useState({
        jmbg:"",
        bankaId:""
    })

    const [racuni,setRacuni]=useState([])

    const [tipoviRacuna,setTipoviRacuna]=useState([])

    const [noviRacun,setNoviRacun]=useState({
        imePrezime:"",
        jmbg:"",
        bankaId:"",
        brojRacuna:"",
        tipRacunaId:""
    })

    const navigate=useNavigate();

    const getRacuni=useCallback(()=>{
        TestAxios.get(`/racuni?pageNo=${pageNo}`,{
            params:{
                jmbg:searchParams.jmbg,
                bankaId:searchParams.bankaId             
            }
        })
            .then(res=>{
                console.log(res)
                setRacuni(res.data)
                setPageMax(res.headers['total-pages'])
                
            })
            .catch(()=>{
                alert("Neuspesno dobavljanje !")
            })
    },[pageNo,searchParams])
    
    
    
    useEffect(()=>{
        getRacuni()
        getBanke()
        getTipoveRacuna()
    },[pageNo,searchParams])


    const idiIzmeni=(racunId)=>{
        navigate("/racuni/izmena/"+racunId)
    }

    const renderRacuni=()=>{
        return racuni.map((racun)=>{
            return(
                <tr key={racun.id}>
                    <td>{racun.imePrezime}</td>
                    <td>{racun.jmbg}</td>
                    <td>{racun.stanjeRacuna+" din."}</td>
                    <td>{racun.brojRacuna}</td>
                    <td>{racun.tipRacunaNaziv}</td>
                    <td>{racun.bankaNaziv}</td>
                    <td> {isAdmin && <Button variant="warning" onClick={()=>idiIzmeni(racun.id)}> Izmeni</Button>}</td>
                    <td> {isAdmin && <Button  variant="danger" onClick={()=>obrisiRacun(racun.id)}> Obrisi </Button>}</td>
                </tr>

                  
            )      
        })
    }

    const obrisiRacun=(zadatakId)=>{
        TestAxios.delete("/racuni/"+zadatakId)
            .then((res)=>{
                console.log(res)
                window.location.reload()
            })
            .catch((error)=>{
                if(error.message==="Request failed with status code 403")
                     alert("Stanje na racunu mora biti nula !")
                else
                alert("Neuspesno brisanje !")
            })
    }

  

    const getBanke=useCallback(()=>{
        TestAxios.get("/banke")
            .then(res=>{
                console.log(res.data)
                setBanke(res.data)
            })
            .catch(()=>{
                alert("Neuspesno dobavljanje !")
            })
    },[])

    const getTipoveRacuna=useCallback(()=>{
        TestAxios.get("/racuni")
            .then(res=>{
                console.log(res.data)
                setTipoviRacuna(res.data)
            })
            .catch(()=>{
                alert("Neuspesno dobavljanje !")
            })
    },[])



    const handleChange=(e)=>{
        const{name,value}=e.target 
        setSearchParams({...searchParams,[name]:value})
        console.log({[e.target.name]: e.target.value}) 
    }

   
    const handleSearch=()=>{
        window.location.reload()
    }

    const inputValueChanged=(e)=>{
        const {name,value}=e.target  
        setNoviRacun({...noviRacun,[name]:value})

        console.log({[e.target.name]: e.target.value})
    }


    const dodajRacun=()=>{
        TestAxios.post("/racuni",{
            imePrezime:noviRacun.imePrezime,
            jmbg:noviRacun.jmbg,
            bankaId:noviRacun.bankaId,
            brojRacuna:noviRacun.brojRacuna,
            tipRacunaId:noviRacun.tipRacunaId

        })
            .then((res)=>{
                console.log(res.data)
                window.location.reload()
                
            })
            .catch(()=>{
                alert("Neuspesno dodavanje !")
            })
        
    }

    const idiNaPrenos=()=>{
        navigate("/racuni/prenos")
    }

    return(
<Row>

        <Row>







        <Row>
                <Col > 

               
                    <Form>

                        <Form.Group>
                            <br/>
                            <Form.Label>Ime i prezime</Form.Label>
                            <Form.Control  name="imePrezime" onChange={inputValueChanged}></Form.Control>
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>JMBG</Form.Label>
                            <Form.Control id="zaduzeni" name="jmbg" onChange={inputValueChanged}></Form.Control>
                        </Form.Group>

                    

                        <Form.Group>
                        <Form.Label>Banka</Form.Label>
                        <Form.Control  as='select' name="bankaId" onChange={inputValueChanged} >
                            <option></option>
                            {
                                banke.map((banka)=>{
                                    return <option key={banka.id} value={banka.id} >{banka.naziv}</option>
                                })
                            }
                        </Form.Control>
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Broj racuna</Form.Label>
                            <Form.Control   name="brojRacuna" onChange={inputValueChanged}></Form.Control>
                        </Form.Group>

                        <Form.Group>
                        <Form.Label>Tip racuna</Form.Label>
                        <Form.Control as='select' name="tipRacunaId" onChange={inputValueChanged}>
                            <option> </option>
                            {
                                racuni.map((racun)=>{
                                    return <option key={racun.id} value={racun.id} >{racun.tipRacunaNaziv}</option>
                                })
                            }
                        </Form.Control>
                        </Form.Group>

                        <br/>
                       < Button onClick={()=>dodajRacun()}>Add</Button>
                        <br/>

                    </Form>

                </Col>
                </Row>













            

        <Row>
                    <Col>
                    <Form>

                        <Form.Group><br/>
                            <Form.Label> JMBG</Form.Label>
                            <Form.Control name="jmbg" onChange={handleChange} />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label> Banka </Form.Label>
                            <Form.Control as='select' name="bankaId" onChange={handleChange} >
                                <option ></option>
                                {
                                    banke.map((banka)=>{
                                        return <option key={banka.id} value={banka.id}> {banka.naziv} </option>
                                    })
                                }
                            </Form.Control>
                            <br/>
                           
                            <Col>
                              <Button onClick={()=>handleSearch()}>Osvezi pretragu</Button>
                            </Col>

                            
                                   
                        </Form.Group>

                    </Form>
                    </Col>

                </Row>

        </Row>
        


        <Row>

            <Row>
                
                <Col>
               
                    <div style={{ display: 'flex', justifyContent: "space-between" }}>
                        <span>
                            <br></br>
                            <Button onClick={()=>idiNaPrenos()}>Prenos</Button>
                        </span>
                        <span>
                            <br></br>
                            <Button style={{ marginRight: '5px'}} disabled={pageNo<=0} onClick={(e)=>setPageNo(pageNo-1)}> Previous</Button>
                            <Button disabled={pageNo>=pageMax-1} onClick={(e)=>setPageNo(pageNo+1)}> Next </Button>
                            
                        
                        </span>
                    </div>

                </Col>
                </Row>

            <Row> 
            <Col>
                <Table className="table-striped table-bordered table-hover">

                    <thead className="table-dark">
                        <tr>
                            <th> Ime i prezime  </th>
                            <th> JMBG </th>
                            <th> Stanje </th>
                            <th> Broj racuna </th>
                            <th> Tip racuna </th>
                            <th> Banka </th>
                            <th> Akcije </th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                    {renderRacuni()}
                    </tbody>
                </Table>

            </Col>
            </Row>
            
        </Row>

        </Row>
    )

}

export default Racun;