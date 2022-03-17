import React from 'react';
import './App.css';
import Config from './Config';

import p_grammar from './images/grammar_banner.png';


/////////////////////////////////////////////

const DEBUG = Config.DEBUG;

if(DEBUG) console.log("homepage top");

class GrammarDiagrams extends React.Component {
	
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
                <img src={p_grammar} style={{paddingBottom:"60px", paddingTop:"60px"}} alt=""></img>
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
                        Grammar
                        <div style={{
                            backgroundColor: Config.COLOR_BONEWHITE,
                            fontFamily:"arial",
                            fontSize: "16px",
                            lineHeight: "30px",
                            color: Config.COLOR_MIDNIGHTBLACK,
                            paddingTop: "50px",
                            paddingLeft: "70px",
                            paddingBottom: "50px",
                            marginBottom:"50px",
                            }}>
                            Genetic codes of viruses and antibodies are governed by the following grammar.<br/>
                            Terminal symbols are written in <span style={{fontFamily:"monospace"}}>monospace</span> font; nonterminal symbols are written in italics.<br/>
                            <br/>
                            <span style={{fontStyle:"italic"}}>
                            Program → Statement<span style={{color:"blue"}}>+</span> <br/>
                            Statement → Command | BlockStatement | IfStatement | WhileStatement<br/>
                            Command → AssignmentStatement | ActionCommand
                            AssignmentStatement → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>{"<identifier>"}</span> = Expression<br/>
                            ActionCommand → MoveCommand | AttackCommand<br/>
                            MoveCommand → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>move</span> Direction<br/>
                            AttackCommand → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>shoot</span> Direction<br/>
                            Direction → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>left | right | up | down | upleft | upright | downleft | downright</span><br/>
                            BlockStatement → {"{"} Statement<span style={{color:"blue"}}>*</span> {"}"}<br/>
                            IfStatement → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>if</span> ( Expression ) <span style={{fontFamily:"monospace", fontStyle:"normal"}}>then</span> Statement <span style={{fontFamily:"monospace", fontStyle:"normal"}}>else</span> Statement<br/>
                            WhileStatement → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>while</span> ( Expression ) Statement<br/>
                            Expression → Expression + Term | Expression - Term | Term<br/>
                            Term → Term * Factor | Term / Factor | Term % Factor | Factor<br/>
                            Factor → Power ^ Factor | Power<br/>
                            Power → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>{"<number>"} | {"<identifier>"}</span> | ( Expression ) | SensorExpression<br/>
                            SensorExpression → <span style={{fontFamily:"monospace", fontStyle:"normal"}}>virus | antibody | nearby</span> Direction<br/>
                            </span>
                            <br/>
                            <span style={{color:"blue"}}>+</span> means at least one<br/>
                            <span style={{color:"blue"}}>*</span> means zero or more<br/>
                            <span style={{fontFamily:"monospace", fontStyle:"normal"}}>{"<number>"}</span> is any nonnegative floating point literal.<br/>
                            <span style={{fontFamily:"monospace", fontStyle:"normal"}}>{"<identifier>"}</span> is any string not a reserved word.<br/>
                            Identifiers must start with a letter, followed by zero or more alphanumeric characters.<br/>

                            The following strings are reserved words and cannot be used as identifiers: <span style={{fontFamily:"monospace"}}>antibody, down, downleft, downright,<br/>
                            else, if, left, move, nearby, right, shoot, then, up, upleft, upright, virus, while</span>

                        </div>

                        Evaluation Order
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom: "100px",
                            }}>
                            <div>At each time step, viruses and antibodies</div>
                            <div>(collectively called hosts) are evaluated</div>
                            <div>in the order they enter your body.</div>
                            
                        </div>

                        Variables (Identifiers)
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom: "100px",
                            }}>
                            <div>All variables have initial value of 0.</div>
                            <div>Except "random" variable which always returns</div>
                            <div>a random integer between 0 and 99 (inclusive)</div>
                        </div>

                        Boolean Evaluation
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom: "100px",
                            }}>
                            <div>Conditions in the if and while statements</div>
                            <div>evaluate to numbers. To interpret number values</div>
                            <div>as booleans, positive values are considered true,</div>
                            <div>and negative values and zero are considered false.</div>
                            <div>_________</div>
                            <div>Also, while loop has a 100 loop count limit</div>
                        </div>

                        Furthur Studies
                        <div style={{
                            fontSize: "24px",
                            color: Config.COLOR_BONEWHITE,
                            paddingLeft: "70px",
                            paddingBottom: "100px",
                            }}>
                            <div>For better understanding of genetic codes, see</div>
                            <a href="https://docs.google.com/document/d/1Ot27PkVhBcxJvZG_gWaoG7TBo_85UVFYwxLMEPH5-C0/edit#"
                            target="_blank" rel="noopener noreferrer"
                            style={{
                                color:Config.COLOR_LIGHTBLUE,
                                textDecoration:"underline"
                            }}
                            >
                                This Documentation
                            </a>
                        </div>

                    </div>
                </div>
            </div>
                
		)
	}
}

export default GrammarDiagrams;
