import React from 'react';
import './App.css';
import Config from './Config';

import p_units from './images/units_banner.png';
import p_unitRange_diagram from './images/unitRange_diagram.png';
import p_unitDirection_diagram from './images/unitDirection_diagram.png'

/////////////////////////////////////////////

const DEBUG = Config.DEBUG;

if(DEBUG) console.log("unitdiagram top");

class UnitDiagrams extends React.Component {
	
	componentDidMount() {
		
	}

	componentDidUpdate(){
		
	}

	componentWillUnmount(){
		
	}

	render() {
		return (
            <div style={{
                width:"1280px"
            }}>
                <img src={p_units} style={{paddingBottom:"60px", paddingTop:"60px"}} alt=""></img>
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
                        Unit Types
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom:"100px",
                            }}>
                            <div>There are 3 unit types for both <span style={{color:Config.COLOR_BRIGHTRED}}>VIRUS</span> and <span style={{color:Config.COLOR_LIGHTBLUE}}>ANTIBODY</span>.</div>

                            <div>- MELEE: fast move speed, short attack range,<br/> high health.</div>
                            <br/>
                            <div>- RANGED: medium move speed, long attack range,<br/> medium health.</div>
                            <br/>
                            <div>- AOE: low move speed, medium attack range,<br/> low health,also damages units near the unit that<br/> AOE shot at.</div>
                            
                        </div>

                        Genetic Code
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom:"100px",
                            }}>
                            <div>Every unit type has its own GENETIC CODE which</div>
                            <div>dictates how that unit type behaves.</div>
                            <br></br>
                            <div> You can learn about the syntax and how to write</div>
                            <div>GENETIC CODES below.</div>
                            <br></br>
                            <div><span style={{color:Config.COLOR_BRIGHTRED}}>VIRUS</span> have a pre-determined GENETIC CODE but for</div>
                            <div><span style={{color:Config.COLOR_LIGHTBLUE}}>ANTIBODY</span>, you may write your own GENETIC CODE in </div>
                            <div>the next section.</div>
                        </div>
                        
                        ActionCommands
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom:"100px"
                            }}>
                            <div>In each time step, a unit can do 1 action command.</div>
                            <div>- <span style={{color:Config.COLOR_LIGHTBLUE}}>Move</span> in a direction </div>
                            <div>- <span style={{color:Config.COLOR_LIGHTBLUE}}>Shoot</span> in a direction </div>
                            <div>- <span style={{color:Config.COLOR_LIGHTBLUE}}>Stay</span> still (if none of the 2 above is executed) </div>
                        </div>

                        Shooting
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom:"100px"
                            }}>
                            <div>When a unit shoots in a direction, the first unit</div>
                            <div>considered to be in that direction gets shot</div>
                            <div>regardless of whether that unit is friendly or not.</div>
                            <div>_________</div>
                            <div>In short, there is FRIENDLY FIRE.</div>
                        </div>

                        Moving
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom:"100px"
                            }}>
                            <div>When a unit  attempts to moves in a direction,</div>
                            <div>if the target position is not occupied,</div>
                            <div>it moves there.</div>
                            <div>_________</div>
                            <div>In short, units can go OVER each other.</div>
                        </div>

                        Sensing
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom:"100px"
                            }}>
                            <div>Sensing command returns a 2 digit integer.</div>
                            
                            <br></br>
                            <div>Units can sense for:</div>
                            <div>- nearest <span style={{color:Config.COLOR_BRIGHTRED}}>VIRUS</span></div>
                            <div>- nearest <span style={{color:Config.COLOR_LIGHTBLUE}}>ANTIBODY</span></div>
                            <div>Digit1 is the range.</div>
                            <div>Digit2 is the direction.</div>
                            <br></br>
                            <div>- nearest UNIT in a direction</div>
                            <div>Digit1 is the range.</div>
                            <div>Digit2 is the type: 1 for <span style={{color:Config.COLOR_BRIGHTRED}}>VIRUS</span>, 2 for <span style={{color:Config.COLOR_LIGHTBLUE}}>ANTIBODY</span>.</div>
                        </div>

                        Range 
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px"
                            }}>
                            <div>Units have 3 detect ranges.</div>
                            <div>Each range is represented by a number.</div>
                            <div>_________</div>
                            <div>Close - 1, Attack - 2, Detect - 3</div>
                        </div>
                        <img src={p_unitRange_diagram} style={{paddingBottom:"100px", paddingTop:"30px"}} alt=""></img>

                        Direction
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            }}>
                            <div>Units detect in a 45 degree range in each direction.</div>
                            <div>Each direction is represented by a number.</div>
                            <div>_________</div>
                            <div>Up - 1, UpRight - 2, Right - 3, DownRight - 4</div>
                            <div>Down - 5, DownLeft - 6, Left - 7, UpLeft - 8</div>
                        </div>
                        <img src={p_unitDirection_diagram} style={{paddingBottom:"100px", paddingTop:"30px"}} alt=""></img>
                    </div>
                </div>
            </div>
		)
	}
}

export default UnitDiagrams;                
                