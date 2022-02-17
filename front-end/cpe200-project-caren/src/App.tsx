import React from 'react';
import './App.css';
import Config from './Config';
import ImageObject from './ImageObject';
import TextObject from './TextObject';

// controllers
import GameController from './controllers/GameController';

// pngs
import p_main_background from './assets/artworks/main_background.png'
import p_dim_black from './assets/artworks/dim_black.png'
import p_alertLight_blue from './assets/artworks/alertLight_blue.png'
import p_brain_blue from './assets/artworks/brain_blue.png'
import p_brain_red from './assets/artworks/brain_red.png'
import p_lungs_blue from './assets/artworks/lungs_blue.png'
import p_lungs_red from './assets/artworks/lungs_red.png'
import p_heart_blue from './assets/artworks/heart_blue.png'
import p_heart_red from './assets/artworks/heart_red.png'
import p_scanner from './assets/artworks/scanner.png'

import p_money_panel from './assets/artworks/money_panel.png'
import p_buy_melee from './assets/artworks/unitFrame_melee.png'
import p_buy_melee_clicked from './assets/artworks/unitFrame_melee_clicked.png'
import p_buy_melee_hover from './assets/artworks/unitFrame_melee_hover.png'
import p_buy_ranged from './assets/artworks/unitFrame_ranged.png'
import p_buy_ranged_clicked from './assets/artworks/unitFrame_ranged_clicked.png'
import p_buy_ranged_hover from './assets/artworks/unitFrame_ranged_hover.png'
import p_buy_aoe from './assets/artworks/unitFrame_aoe.png'
import p_buy_aoe_clicked from './assets/artworks/unitFrame_aoe_clicked.png'
import p_buy_aoe_hover from './assets/artworks/unitFrame_aoe_hover.png'
import ButtonObject from './ButtonObject';

var canvas : HTMLCanvasElement | null;
var ctx: CanvasRenderingContext2D | null;

/// ELEMENTS
var i_main_background: ImageObject;
var i_brain : ImageObject;
var i_heart : ImageObject;
var i_lungs : ImageObject;

// dim black
var i_dim_black : ImageObject;
var i_scanner : ImageObject;

// shop
var i_money_panel : ImageObject;
var t_money : TextObject;

var i_buy_melee : ButtonObject;
var i_buy_ranged : ButtonObject;
var i_buy_aoe : ButtonObject;

// scanner
var i_alertLight_blue: ImageObject;

// pregame
var t_caren : TextObject;
var t_howToPlay : TextObject;
var t_clickAnywhereToStart : TextObject;


/// FETCHABLE FIELDS
var gameState : number = 1; // 1 = pregame, 2 = game
var activeAreaIndex : number = 1; // 0 = none, 1 = area1, 2 = area2, 3 = area3
var areas = [null,null,null]; // area datas
var money : number = 0; // money 

/// FIELDS
var isHover = false;
var mousePosition : {x:number, y:number};

/// CONSTANTS
const screenWidth = 1280;
const screenHeight = 720;

const imageScaling = 0.6666667;

console.log("top");

const DEBUG = true;

class App extends React.Component {
	interval: NodeJS.Timer | undefined;
	
	constructor(props : any) {
		super(props);
	}

	componentDidMount() {
		if(DEBUG) console.log("MOUNTED");
		this.interval = setInterval(() => this.setState({ time: Date.now() }), 1000/Config.FPS);
		
		this.initAll();
		this.fetchAll();
		this.updateAll();
	}

	componentDidUpdate(){
		this.fetchAll();
		this.updateAll();
		this.drawAll();
	}

	componentWillUnmount(){
		clearInterval(this.interval!);
	}

	initAll(){
		if(DEBUG) console.log("INITALL")
		canvas = document.querySelector('canvas');
		canvas!.width = 1280
		canvas!.height = 720

		// EVENTLISTENERS
		canvas!.addEventListener('mousedown', function(e){ onMouseDown(e); getMousePosition(canvas!, e)});
		canvas!.addEventListener('mouseup', function(e){ onMouseUp(e); getMousePosition(canvas!, e)});
		canvas!.addEventListener('mousemove', function(e){ onMouseHover(e); getMousePosition(canvas!, e)});
		canvas!.addEventListener('mouseout', function(e){ onMouseHover(e); getMousePosition(canvas!, e)});
		
		
		ctx = canvas!.getContext('2d')
		ctx!.scale(imageScaling,imageScaling);
		ctx!.imageSmoothingEnabled = false;


		i_main_background = new ImageObject(p_main_background,0,0)
		i_brain = new ImageObject([p_brain_blue, p_brain_red],808,74)
		i_lungs = new ImageObject([p_lungs_blue, p_lungs_red],780,501)
		i_heart = new ImageObject([p_heart_blue, p_heart_red],932,453)

		// dim black
		i_dim_black = new ImageObject(p_dim_black, 0,0);
		i_scanner = new ImageObject(p_scanner, 245, 28);

		// shop
		i_money_panel = new ImageObject(p_money_panel,1476,79);
		t_money = new TextObject([money.toString()], 40, "'Press Start 2P'", 1696, 123, Config.COLOR_LIGHTBLUE, "center");

		i_buy_melee = new ButtonObject([p_buy_melee,p_buy_melee_hover,p_buy_melee_clicked], 1712, 256);
		i_buy_ranged = new ButtonObject([p_buy_ranged, p_buy_ranged_hover, p_buy_ranged_clicked], 1712, 381);
		i_buy_aoe = new ButtonObject([p_buy_aoe, p_buy_aoe_hover, p_buy_aoe_clicked], 1712, 506);

		// scanner
		i_alertLight_blue = new ImageObject(p_alertLight_blue,0,0)

		// pregame
		t_caren = new TextObject(["C.A.R.E.N"], 96, "'Press Start 2P'", 112, 235)
		t_howToPlay = new TextObject([
			"Covid VIRUS is attacking!",
			"",
			"",
			"• You must protect your organs: brain, heart, and lungs",
			"• Don’t let the amount of ANTIBODY reach zero or you lose the organ",
			"• Each lost organ increase the VIRUS amount by x1.5",
			"• Buy ANTIBODY with ANTIBODY CREDITS earned from killing VIRUS",
			"• ANTIBODY turns into VIRUS when it dies",
			"• Program how your ANTIBODY behaves below",
			"   (or don’t, you can use our default programs)",
			"• Survive the 5 VIRUS WAVES to win!"
			],
			18, "'Press Start 2P'", 112, 398)
		t_clickAnywhereToStart = new TextObject(["CLICK ANYWHERE TO START"], 24, "'Press Start 2P'", 112, 904)
	}

	fetchAll(){
		if(DEBUG) console.log("FETCHALL")
		GameController.getGameState().then(data => gameState = data);

		GameController.getMoney().then(data => money = data);

		for(var i = 0 ; i < 3; ++i){
			GameController.getArea(i+1).then(data => {
				areas[i] = data;
				if(DEBUG) console.log(areas[i]);
			});
		}
		
		if(DEBUG) console.log(gameState)
	}

	
	updateAll(){
		if(DEBUG) console.log("UPDATEALL")
		ctx!.clearRect(0,0,screenWidth, screenHeight);

		t_money.setText([money.toString()]);

		// isHover == true
		if(isHover){
			if(gameState === 2){
				i_buy_melee.setHover(i_buy_melee.mouseInside(mousePosition));
				i_buy_ranged.setHover(i_buy_ranged.mouseInside(mousePosition));	
				i_buy_aoe.setHover(i_buy_aoe.mouseInside(mousePosition));
			}
		}
		

		if(DEBUG) i_heart.nextState();
	}

	drawAll(){
		if(DEBUG) console.log("DRAWALL")
		if(DEBUG) console.log("gameState: " + gameState)
		i_main_background.draw();

		i_brain.draw();
		i_heart.draw();
		i_lungs.draw();

		

		// dim black
		if(gameState === 2 && activeAreaIndex !== 0){
			i_dim_black.draw();
		}
		

		//shop
		i_money_panel.draw();
		t_money.draw();
		
		i_buy_melee.draw();
		i_buy_ranged.draw();
		i_buy_aoe.draw();

		// scanner
		if(gameState === 2){
			if(activeAreaIndex !== 0){
				i_scanner.draw();
			}
		}

		// pre game
		if(gameState === 1){
			i_dim_black.draw();
		}
		if(gameState === 1){
			t_caren.draw();
			t_howToPlay.draw();
			t_clickAnywhereToStart.draw();
		}
		
	}

	

	render() {
		return (
			<canvas></canvas>
		)
	}
}

export default App;

function onMouseHover(e : MouseEvent){
	if (DEBUG) console.log("mousehover");
	isHover = true;
}

function onMouseUp(e : MouseEvent){
	if (DEBUG) console.log("mouseup");

	if(gameState === 2){
		// if(!i_buy_melee.mouseInside(mousePosition)){
		// 	i_buy_melee.setClicked(false);
		// }
		// if(!i_buy_ranged.mouseInside(mousePosition)){
		// 	i_buy_ranged.setClicked(false);	
		// }
		// if(!i_buy_aoe.mouseInside(mousePosition)){
		// 	i_buy_aoe.setClicked(false);
		// }
		i_buy_melee.mouseUp();
		i_buy_ranged.mouseUp();
		i_buy_aoe.mouseUp();
	}
}

function onMouseDown(e : MouseEvent){
	if (DEBUG) console.log("mousedown");
	if (DEBUG) console.log(mousePosition);

	if(gameState === 1){
		if(i_dim_black.mouseInside(mousePosition)){
			gameState = 2;
			// call game state change api
			GameController.setGameState(gameState);
		}
	}
	if(gameState === 2){
		if(i_dim_black.mouseInside(mousePosition)){

			if(activeAreaIndex === 0){

			}else if(i_scanner.mouseInside(mousePosition) === false){
				activeAreaIndex = 0;
			}
		}
		if(i_brain.mouseInside(mousePosition)){
			if(activeAreaIndex === 0){
				activeAreaIndex = 1;
			}
		}else if(i_heart.mouseInside(mousePosition)){
			if(activeAreaIndex === 0){
				activeAreaIndex = 2;
			}
		}else if(i_lungs.mouseInside(mousePosition)){
			if(activeAreaIndex === 0){
				activeAreaIndex = 3;
			}
		}
		if(gameState === 2){
			i_buy_melee.setClicked(i_buy_melee.mouseInside(mousePosition));
			i_buy_ranged.setClicked(i_buy_ranged.mouseInside(mousePosition));	
			i_buy_aoe.setClicked(i_buy_aoe.mouseInside(mousePosition));
		}
		
		
	}
}

function getMousePosition(canvas : HTMLCanvasElement, e : MouseEvent){
	var canvasRect = canvas.getBoundingClientRect();
	mousePosition = {x: e.clientX - canvasRect.left, y: e.clientY - canvasRect.top};
	return mousePosition;
}

