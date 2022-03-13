import React from 'react';
import App from './App';
import "./index.css";
import "@fontsource/press-start-2p";
import './App.css';
import Config from './Config';
import Header from './Header';
import UnitDiagrams from './UnitDiagrams';
import GrammarDiagrams from './GrammarDiagrams';

;

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
            <div style={{
                backgroundColor:Config.COLOR_MIDNIGHTBLACK, width:"100%",
                display: "flex",flexDirection: "column", justifyContent: "center", alignItems: "center" 
                }}>
                <Header></Header>
                <App></App>
                <UnitDiagrams></UnitDiagrams>
                <GrammarDiagrams></GrammarDiagrams>
            </div>
		)
	}
}

export default HomePage;



