import React from 'react';
import './App.css';
import Config from './Config';

import p_gCode from './images/gCodes_banner.png';

/////////////////////////////////////////////

const DEBUG = Config.DEBUG;

if(DEBUG) console.log("geneticcodeinput top");

class GeneticCodeInput extends React.Component {
	
	componentDidMount() {
		
	}

	componentDidUpdate(){
		
	}

	componentWillUnmount(){
		
	}

	render() {
		return (
            <div style={{paddingBottom:"60px"}}>
                <img src={p_gCode} style={{paddingBottom:"60px", paddingTop:"60px"}} alt=""></img>
                <div style={{
                    justifyContent: "start", alignItems:"start",
                    color:Config.COLOR_BONEWHITE
                }}> 
                    <div style={{
                        backgroundColor:Config.COLOR_MEDIUMDIMMEDBLUE,
                        fontFamily:"Press Start 2P", fontSize:"30px",
                        color: Config.COLOR_LIGHTBLUE,
                        padding:"20px",
                        border:"5px",borderStyle:"", borderColor: Config.COLOR_BONEWHITE,borderRadius:"10px",
                    }}>
                        ANTIBODY - MELEE Genetic Code <br></br>
                        <input type="button" value={"Save"}
                            style={{
                                fontSize:"20px", fontFamily:"monospace",
                                color:Config.COLOR_MIDNIGHTBLACK,
                                borderRadius:"10px",
                                padding:"8px", marginBottom:"10px",
                            }}></input>
                        <div>
                            <textarea id="meleeGeneticCode" className="textarea"
                                style={{
                                    fontSize:"16px", fontFamily:"monospace",
                                    color:Config.COLOR_MIDNIGHTBLACK,
                                    padding:"10px",
                                    overflowY: "scroll",
                            }}  defaultValue={Config.DEFAULTGENETICCODE_MELEE}
                            ></textarea>
                        </div> <br></br>
                        ANTIBODY - RANGED Genetic Code <br></br>
                        <input type="button" value={"Save"}
                            style={{
                                fontSize:"20px", fontFamily:"monospace",
                                color:Config.COLOR_MIDNIGHTBLACK,
                                borderRadius:"10px",
                                padding:"8px", marginBottom:"10px",
                            }}></input>
                        <div>
                            <textarea id="rangedGeneticCode" className="textarea"
                                style={{
                                    fontSize:"16px", fontFamily:"monospace",
                                    color:Config.COLOR_MIDNIGHTBLACK,
                                    padding:"10px",
                                    overflowY: "scroll",
                            }}  defaultValue={Config.DEFAULTGENETICCODE_MELEE}
                            ></textarea>

                        </div> <br></br>
                        ANTIBODY - AOE Genetic Code <br></br>
                        <input type="button" value={"Save"}
                            style={{
                                fontSize:"20px", fontFamily:"monospace",
                                color:Config.COLOR_MIDNIGHTBLACK,
                                borderRadius:"10px",
                                padding:"8px", marginBottom:"10px",
                            }}></input>
                        <div>
                            <textarea id="aoeGeneticCode"className="textarea"
                                style={{
                                    fontSize:"16px", fontFamily:"monospace",
                                    color:Config.COLOR_MIDNIGHTBLACK,
                                    padding:"10px",
                                    overflowY: "scroll",
                            }}  defaultValue={Config.DEFAULTGENETICCODE_MELEE}
                            ></textarea>

                        </div>
                    </div>
                </div>
            </div>
		)
	}
}

export default GeneticCodeInput;

