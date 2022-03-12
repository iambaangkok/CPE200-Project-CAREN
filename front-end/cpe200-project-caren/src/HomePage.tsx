import React from 'react';
import App from './App';
import "./index.css";
import "@fontsource/press-start-2p";
import './App.css';
import Config from './Config';
import Header from './Header';

import p_units from './images/units_banner.png';
import p_unitRange_diagram from './images/unitRange_diagram.png';

/////////////////////////////////////////////

const DEBUG = Config.DEBUG;

if(DEBUG) console.log("homepage top");

class HomePage extends React.Component {
	
	componentDidMount() {
		
	}

	componentDidUpdate(){
		
	}

	componentWillUnmount(){
		
	}

	render() {
		return (
            <div style={{backgroundColor:Config.COLOR_MIDNIGHTBLACK, width:"100%", display: "flex",flexDirection: "column", justifyContent: "center", alignItems: "center"}} >
                <Header></Header>
                <App></App>
                <img src={p_units} style={{paddingBottom:"60px", paddingTop:"60px"}}></img>
                <div style={{
                    justifyContent: "start", alignItems:"start",
                    color:Config.COLOR_BONEWHITE
                }}> 
                    <div style={{
                        fontFamily:"Press Start 2P", fontSize:"30px",
                        color: Config.COLOR_LIGHTBLUE
                        }}>
                        Range 
                        <p style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px"
                            }}>
                            <div>Units have 3 detect ranges</div>
                            <div>Each range is represented by a number</div>
                            <div>_________</div>
                            <div>Close - 1, Attack - 2, Detect - 3</div>
                        </p>
                        <img src={p_unitRange_diagram} style={{paddingBottom:"100px", paddingTop:"30px"}}></img>

                        Direction
                        <p style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            }}>
                            <div>Units detect in a 45 degree range in each direction</div>
                            <div>Each direction is represented by a number</div>
                            <div>_________</div>
                            <div>Up - 1, UpRight - 2, Right - 3, DownRight - 4</div>
                            <div>Down - 5, DownLeft - 6, Left - 7, UpLeft - 8</div>
                        </p>


                    </div>
                </div>
            </div>
		)
	}
}

export default HomePage;

