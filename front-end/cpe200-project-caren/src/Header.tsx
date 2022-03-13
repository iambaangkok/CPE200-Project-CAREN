import React from 'react';
import './App.css';
import Config from './Config';

import p_header from './images/header_v2.png';

/////////////////////////////////////////////

const DEBUG = Config.DEBUG;

if(DEBUG) console.log("header top");

class Header extends React.Component {
	
	componentDidMount() {
		
	}

	componentDidUpdate(){
		
	}

	componentWillUnmount(){
		
	}

	render() {
		return (
            <div style={{paddingBottom:"10px", paddingTop:"30px"}}>
                <img src={p_header} alt=""></img>
            </div>
		)
	}
}

export default Header;

