import React from 'react';
import './App.css';
import Config from './Config';
import ImageObject from './ImageObject';
import ButtonObject from './ButtonObject';
import WaveInfo from './WaveInfo';
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

import p_pause from './assets/artworks/timestepIcon_paused_blank.png';
import p_pause_clicked from './assets/artworks/timestepIcon_paused_filled.png';
import p_play from './assets/artworks/timestepIcon_normal_blank.png';
import p_play_clicked from './assets/artworks/timestepIcon_normal_filled.png';
import p_fastforward from './assets/artworks/timestepIcon_fastforward_blank.png';
import p_fastforward_clicked from './assets/artworks/timestepIcon_fastforward_filled.png';
import p_slowdown from './assets/artworks/timestepIcon_slowdown_blank.png';
import p_slowdown_clicked from './assets/artworks/timestepIcon_slowdown_filled.png';

import p_money_panel from './assets/artworks/money_panel.png'

import p_buy_melee from './assets/artworks/unitFrame_melee.png'
import p_buy_melee_clicked from './assets/artworks/unitFrame_melee_clicked.png'
import p_buy_melee_hover from './assets/artworks/unitFrame_melee_hover.png'
import p_buy_melee_disabled from './assets/artworks/unitFrame_melee_disabled.png'
import p_buy_ranged from './assets/artworks/unitFrame_ranged.png'
import p_buy_ranged_clicked from './assets/artworks/unitFrame_ranged_clicked.png'
import p_buy_ranged_hover from './assets/artworks/unitFrame_ranged_hover.png'
import p_buy_ranged_disabled from './assets/artworks/unitFrame_ranged_disabled.png'
import p_buy_aoe from './assets/artworks/unitFrame_aoe.png'
import p_buy_aoe_clicked from './assets/artworks/unitFrame_aoe_clicked.png'
import p_buy_aoe_hover from './assets/artworks/unitFrame_aoe_hover.png'
import p_buy_aoe_disabled from './assets/artworks/unitFrame_aoe_disabled.png'

import p_melee_icon from './assets/artworks/classIcons_shield.png'
import p_ranged_icon from './assets/artworks/classIcons_gun.png'
import p_aoe_icon from './assets/artworks/classIcons_rocket.png'

import p_waveInfo_triangle from './assets/artworks/waveInfo_triangle.png'; 

import p_unitIcon_melee_blank_blue from './assets/artworks/unitIcon_melee_blank_blue.png';
import p_unitIcon_melee_filled_blue from './assets/artworks/unitIcon_melee_filled_blue.png';
import p_unitIcon_ranged_blank_blue from './assets/artworks/unitIcon_ranged_blank_blue.png';
import p_unitIcon_ranged_filled_blue from './assets/artworks/unitIcon_ranged_filled_blue.png';
import p_unitIcon_aoe_blank_blue from './assets/artworks/unitIcon_aoe_blank_blue.png';
import p_unitIcon_aoe_filled_blue from './assets/artworks/unitIcon_aoe_filled_blue.png';

import p_unitIcon_melee_blank_red from './assets/artworks/unitIcon_melee_blank_red.png';
import p_unitIcon_melee_filled_red from './assets/artworks/unitIcon_melee_filled_red.png';
import p_unitIcon_ranged_blank_red from './assets/artworks/unitIcon_ranged_blank_red.png';
import p_unitIcon_ranged_filled_red from './assets/artworks/unitIcon_ranged_filled_red.png';
import p_unitIcon_aoe_blank_red from './assets/artworks/unitIcon_aoe_blank_red.png';
import p_unitIcon_aoe_filled_red from './assets/artworks/unitIcon_aoe_filled_red.png';

import p_invenButton_top from './assets/artworks/invenButton_top.png';
import p_invenButton_top_blank from './assets/artworks/invenButton_top_blank.png';
import p_invenButton_middle from './assets/artworks/invenButton_middle.png';
import p_invenButton_middle_blank from './assets/artworks/invenButton_middle_blank.png';
import p_invenButton_bottom from './assets/artworks/invenButton_bottom.png';
import p_invenButton_bottom_blank from './assets/artworks/invenButton_bottom_blank.png';
import Vector2 from './Vector2';


var canvas : HTMLCanvasElement | null;
var ctx: CanvasRenderingContext2D | null;

/// ELEMENTS
var i_main_background: ImageObject;
var i_brain : ImageObject;
var i_heart : ImageObject;
var i_lungs : ImageObject;

// dim black
var i_dim_black : ImageObject;

// wave
var t_wave_text : TextObject;
var waveInfo_brain : WaveInfo;
var waveInfo_heart : WaveInfo;
var waveInfo_lungs : WaveInfo;

// timer
var b_time_pause : ButtonObject;
var b_time_play : ButtonObject;
var b_time_fastforward : ButtonObject;
var b_time_slowdown : ButtonObject;

// shop
var i_money_panel : ImageObject;
var t_money : TextObject;

var b_buy_melee : ButtonObject;
var b_buy_ranged : ButtonObject;
var b_buy_aoe : ButtonObject;
var t_buy_melee_cost : TextObject;
var t_buy_ranged_cost : TextObject;
var t_buy_aoe_cost : TextObject;
var i_melee_icon : ImageObject;
var i_ranged_icon : ImageObject;
var i_aoe_icon : ImageObject;
var t_melee_desc : TextObject;
var t_ranged_desc : TextObject;
var t_aoe_desc : TextObject;

// scanner
var i_scanner : ImageObject;
var b_invenButton_top : ButtonObject;
var b_invenButton_middle : ButtonObject;
var b_invenButton_bottom : ButtonObject;

var i_invenIcon_melee : ImageObject;
var i_invenIcon_ranged : ImageObject;
var i_invenIcon_aoe : ImageObject;

var t_inven_melee : TextObject;
var t_inven_ranged : TextObject;
var t_inven_aoe : TextObject;

var i_alertLight_blue: ImageObject;

// pregame
var t_caren : TextObject;
var t_howToPlay : TextObject;
var t_clickAnywhereToStart : TextObject;


/// FETCHABLE FIELDS
var gameState : number = 1; // 1 = pregame, 2 = game
var activeAreaIndex : number = 1; // 0 = none, 1 = area1, 2 = area2, 3 = area3
var areas = [null,null,null]; // area datas
var scannerRadius : number = 100; 

var money : number = 0;
var buyMeleeCost : number = 0;
var buyRangedCost : number = 0;
var buyAoeCost : number = 0;

var currentWave : {
	waveNumber: number, 
	area1: {total: number, melee: number, ranged: number, aoe: number},
	area2: {total: number, melee: number, ranged: number, aoe: number},
	area3: {total: number, melee: number, ranged: number, aoe: number}
} = {
	waveNumber: 0, 
	area1: {total: 0, melee: 0, ranged: 0, aoe: 0},
	area2: {total: 0, melee: 0, ranged: 0, aoe: 0},
	area3: {total: 0, melee: 0, ranged: 0, aoe: 0}
  };

var inventory : {
	melee : number,
	ranged : number,	
	aoe : number,
} = {
	melee : 0,
	ranged : 0,
	aoe : 0
};

/// FIELDS
var isHover = false;
var mousePosition : Vector2;
var scannerMousePosition : Vector2;
var gameTime = 0;
var frameTime = 1000/Config.FPS;


const DEBUG = Config.DEBUG;

if(DEBUG) console.log("top");

class App extends React.Component {
	interval: NodeJS.Timer | undefined;
	
	componentDidMount() {
		if(DEBUG) console.log("MOUNTED");
		this.interval = setInterval(() => this.setState({ time: Date.now() }), frameTime);
		
		this.initAll();
		this.fetchInit();
		this.fetchAll();
		this.updateAll();
	}

	componentDidUpdate(){
		gameTime += frameTime;
		if(gameTime > Config.FETCH_INTERVAL_SECONDS*1000){
			this.fetchAll();
			gameTime -= Config.FETCH_INTERVAL_SECONDS*1000;
		}
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
		ctx!.scale(Config.CANVAS_SCALE,Config.CANVAS_SCALE);
		ctx!.imageSmoothingEnabled = false;


		i_main_background = new ImageObject(p_main_background,0,0)
		i_brain = new ImageObject([p_brain_blue, p_brain_red],808,74)
		i_lungs = new ImageObject([p_lungs_blue, p_lungs_red],780,501)
		i_heart = new ImageObject([p_heart_blue, p_heart_red],932,453)

		// dim black
		i_dim_black = new ImageObject(p_dim_black, 0,0);

		// wave
		t_wave_text = new TextObject(["WAVE " + currentWave.waveNumber.toString() + "/" + Config.MAX_WAVE.toString()], 48, "'Press Start 2P'", 97, 111);

		waveInfo_brain = new WaveInfo(
			new ImageObject(p_waveInfo_triangle, 1140, 142),
			new ImageObject([p_unitIcon_melee_blank_red,p_unitIcon_melee_filled_red], 1180, 142),
			new ImageObject([p_unitIcon_ranged_blank_red,p_unitIcon_ranged_filled_red], 1180, 178),
			new ImageObject([p_unitIcon_aoe_blank_red,p_unitIcon_aoe_filled_red], 1180, 214),
			new TextObject([currentWave.area1.melee.toString()], 28, "'Press Start 2P'", 1224, 144, Config.COLOR_BRIGHTRED),
			new TextObject([currentWave.area1.ranged.toString()], 28, "'Press Start 2P'", 1224, 180, Config.COLOR_BRIGHTRED),
			new TextObject([currentWave.area1.aoe.toString()], 28, "'Press Start 2P'", 1224, 215, Config.COLOR_BRIGHTRED)
		);
		waveInfo_heart = new WaveInfo(
			new ImageObject(p_waveInfo_triangle, 1131, 515),
			new ImageObject([p_unitIcon_melee_blank_red,p_unitIcon_melee_filled_red], 1171, 515),
			new ImageObject([p_unitIcon_ranged_blank_red,p_unitIcon_ranged_filled_red], 1171, 551),
			new ImageObject([p_unitIcon_aoe_blank_red,p_unitIcon_aoe_filled_red], 1171, 587),
			new TextObject([currentWave.area2.melee.toString()], 28, "'Press Start 2P'", 1215, 517, Config.COLOR_BRIGHTRED),
			new TextObject([currentWave.area2.ranged.toString()], 28, "'Press Start 2P'", 1215, 553, Config.COLOR_BRIGHTRED),
			new TextObject([currentWave.area2.aoe.toString()], 28, "'Press Start 2P'", 1215, 588, Config.COLOR_BRIGHTRED)
		);
		waveInfo_lungs = new WaveInfo(
			new ImageObject(p_waveInfo_triangle, 1159, 648),
			new ImageObject([p_unitIcon_melee_blank_red,p_unitIcon_melee_filled_red], 1199, 648),
			new ImageObject([p_unitIcon_ranged_blank_red,p_unitIcon_ranged_filled_red], 1199, 684),
			new ImageObject([p_unitIcon_aoe_blank_red,p_unitIcon_aoe_filled_red], 1199, 720),
			new TextObject([currentWave.area3.melee.toString()], 28, "'Press Start 2P'", 1243, 650, Config.COLOR_BRIGHTRED),
			new TextObject([currentWave.area3.ranged.toString()], 28, "'Press Start 2P'", 1243, 686, Config.COLOR_BRIGHTRED),
			new TextObject([currentWave.area3.aoe.toString()], 28, "'Press Start 2P'", 1243, 721, Config.COLOR_BRIGHTRED)
		);

		// time
		b_time_pause = new ButtonObject([p_pause, p_pause_clicked, p_pause_clicked, p_pause], 141, 172); b_time_pause.setToggle(true);
		b_time_play = new ButtonObject([p_play, p_play_clicked, p_play_clicked, p_play], 197, 172); b_time_play.setToggle(true);
		b_time_fastforward = new ButtonObject([p_fastforward, p_fastforward_clicked, p_fastforward_clicked, p_fastforward], 253, 172); b_time_fastforward.setToggle(true);
		b_time_slowdown = new ButtonObject([p_slowdown, p_slowdown_clicked, p_slowdown_clicked, p_slowdown], 85, 172); b_time_slowdown.setToggle(true);

		// shop
		i_money_panel = new ImageObject(p_money_panel,1476,79);
		t_money = new TextObject([money.toString()], 40, "'Press Start 2P'", 1696, 123, Config.COLOR_LIGHTBLUE, "center");

		b_buy_melee = new ButtonObject([p_buy_melee,p_buy_melee_hover,p_buy_melee_clicked,p_buy_melee_disabled], 1712, 256);
		b_buy_ranged = new ButtonObject([p_buy_ranged, p_buy_ranged_hover, p_buy_ranged_clicked, p_buy_ranged_disabled], 1712, 381);
		b_buy_aoe = new ButtonObject([p_buy_aoe, p_buy_aoe_hover, p_buy_aoe_clicked, p_buy_aoe_disabled], 1712, 506);

		i_melee_icon = new ImageObject(p_melee_icon, 1657, 286);
		i_ranged_icon = new ImageObject(p_ranged_icon, 1657, 410);
		i_aoe_icon = new ImageObject(p_aoe_icon, 1657, 534);

		t_melee_desc = new TextObject(["SHORT-RANGED","TOUGH","FAST"], 20, "'Press Start 2P'", 1632, 274, Config.COLOR_LIGHTBLUE, "end");
		t_ranged_desc = new TextObject(["LONG-RANGED","NORMAL","MEDIUM"], 20, "'Press Start 2P'", 1632, 398, Config.COLOR_LIGHTBLUE, "end");
		t_aoe_desc = new TextObject(["MEDIUM-RANGED-AOE","FRAGILE","SLOW"], 20, "'Press Start 2P'", 1632, 526, Config.COLOR_LIGHTBLUE, "end");
		

		// scanner
		i_scanner = new ImageObject(p_scanner, 245, 28);
		b_invenButton_top = new ButtonObject([p_invenButton_top_blank, p_invenButton_top,p_invenButton_top,p_invenButton_top_blank], 1416, 356); 
		b_invenButton_top.setToggle(true); b_invenButton_top.setClicked(true);
		b_invenButton_middle = new ButtonObject([p_invenButton_middle_blank, p_invenButton_middle,p_invenButton_middle,p_invenButton_middle_blank], 1440, 494); 
		b_invenButton_middle.setToggle(true);
		b_invenButton_bottom = new ButtonObject([p_invenButton_bottom_blank, p_invenButton_bottom,p_invenButton_bottom,p_invenButton_bottom_blank], 1416, 604); 
		b_invenButton_bottom.setToggle(true);

		i_invenIcon_melee = new ImageObject(p_unitIcon_melee_blank_blue, 1448, 395);
		i_invenIcon_ranged = new ImageObject(p_unitIcon_ranged_blank_blue, 1467, 516);
		i_invenIcon_aoe = new ImageObject(p_unitIcon_aoe_blank_blue, 1472, 629);

		t_inven_melee = new TextObject(['x' + inventory.melee.toString()], 20, "'Press Start 2P'", 1468, 438, Config.COLOR_LIGHTBLUE, "center");
		t_inven_ranged = new TextObject(['x' + inventory.ranged.toString()], 20, "'Press Start 2P'", 1486, 561, Config.COLOR_LIGHTBLUE, "center");
		t_inven_aoe = new TextObject(['x' + inventory.aoe.toString()], 20, "'Press Start 2P'", 1488, 676, Config.COLOR_LIGHTBLUE, "center");

		i_alertLight_blue = new ImageObject(p_alertLight_blue,0,0);

		// pregame
		t_caren = new TextObject(["C.A.R.E.N"], 96, "'Press Start 2P'", 112, 235);
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
			18, "'Press Start 2P'", 112, 398, Config.COLOR_CREAMWHITE, "start", "top", 2)
		t_clickAnywhereToStart = new TextObject(["CLICK ANYWHERE TO START"], 24, "'Press Start 2P'", 112, 904)
	}

	fetchInit(){
		if(DEBUG) console.log("FETCHINIT")
		GameController.getUnitCost().then(data => {
			buyMeleeCost = data.melee;
			buyRangedCost = data.ranged;
			buyAoeCost = data.aoe;

			t_buy_melee_cost = new TextObject([buyMeleeCost.toString()], 20, "'Press Start 2P'", 1801, 248, Config.COLOR_LIGHTBLUE, "start");
			t_buy_ranged_cost = new TextObject([buyRangedCost.toString()], 20, "'Press Start 2P'", 1801, 372, Config.COLOR_LIGHTBLUE, "start");
			t_buy_aoe_cost = new TextObject([buyAoeCost.toString()], 20, "'Press Start 2P'", 1801, 497, Config.COLOR_LIGHTBLUE, "start");
		});
	}

	fetchAll(){
		if(DEBUG) console.log("FETCHALL")
		GameController.getGameState().then(data => gameState = data);

		GameController.getMoney().then(data => money = data);

		if(gameState === 2)
		GameController.getWave().then(data => {
			currentWave = data;
			waveInfo_brain.setAllField(currentWave.area1);
			waveInfo_heart.setAllField(currentWave.area2);
			waveInfo_lungs.setAllField(currentWave.area3);
			t_wave_text.setText(["WAVE " + currentWave.waveNumber.toString() + "/" + Config.MAX_WAVE.toString()]);
		});

		GameController.getSpeedMultiplier().then(data => {
			b_time_pause.setClicked(data.type === "pause");
			b_time_play.setClicked(data.type === "play");
			b_time_fastforward.setClicked(data.type === "fastforward");
			b_time_slowdown.setClicked(data.type === "slowdown");
		});

		for(let i = 0 ; i < 3; ++i){
			GameController.getArea(i+1).then(data => {
				areas[i] = data;
				if(DEBUG) console.log(areas[i]);
			});
		}

		GameController.getInventory().then(data => {
			inventory = data;
		});
		
		if(DEBUG) console.log(gameState)
	}

	
	updateAll(){
		if(DEBUG) console.log("UPDATEALL")
		ctx!.clearRect(0,0,Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

		t_money.setText([money.toString()]);

		if(gameState === 2){

			if(isHover){
				b_buy_melee.setHover(b_buy_melee.mouseInside(mousePosition));
				b_buy_ranged.setHover(b_buy_ranged.mouseInside(mousePosition));	
				b_buy_aoe.setHover(b_buy_aoe.mouseInside(mousePosition));
			}
			b_buy_melee.setDisabled(!(money >= buyMeleeCost));
			b_buy_ranged.setDisabled(!(money >= buyRangedCost));
			b_buy_aoe.setDisabled(!(money >= buyAoeCost));

			t_inven_melee.setText(['x' + inventory.melee.toString()]);
			t_inven_ranged.setText(['x' + inventory.ranged.toString()]);
			t_inven_aoe.setText(['x' + inventory.aoe.toString()]);
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
		
		// wave
		t_wave_text.draw();

		if(currentWave.area1.total > 0){
			waveInfo_brain.draw();
		}
		if(currentWave.area2.total > 0){
			waveInfo_heart.draw();
		}
		if(currentWave.area3.total > 0){
			waveInfo_lungs.draw();
		}
		// time
		b_time_pause.draw();
		b_time_play.draw();
		b_time_fastforward.draw();
		b_time_slowdown.draw();

		//shop
		i_money_panel.draw();
		t_money.draw();
		
		b_buy_melee.draw();
		b_buy_ranged.draw();
		b_buy_aoe.draw();

		t_buy_melee_cost?.draw();
		t_buy_ranged_cost?.draw();
		t_buy_aoe_cost?.draw();

		if(b_buy_melee.isHover()){
			i_melee_icon.draw();
			t_melee_desc.draw();
		} 
		if(b_buy_ranged.isHover()){
			i_ranged_icon.draw();
			t_ranged_desc.draw();
		} 
		if(b_buy_aoe.isHover()){
			i_aoe_icon.draw();
			t_aoe_desc.draw();
		} 

		// scanner
		if(gameState === 2){
			if(activeAreaIndex !== 0){
				i_scanner.draw();
				b_invenButton_top.draw();
				b_invenButton_middle.draw();
				b_invenButton_bottom.draw();
				i_invenIcon_melee.draw();
				i_invenIcon_ranged.draw();
				i_invenIcon_aoe.draw();
				t_inven_melee.draw();
				t_inven_ranged.draw();
				t_inven_aoe.draw();
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
		b_buy_melee.mouseUp();
		b_buy_ranged.mouseUp();
		b_buy_aoe.mouseUp();
	}
}

function onMouseDown(e : MouseEvent){
	if (DEBUG) console.log("mousedown");
	if (true) console.log(mousePosition);
	if (true) console.log(scannerMousePosition);

	if(gameState === 1){
		if(i_dim_black.mouseInside(mousePosition)){
			gameState = 2;
			// call game state change api
			GameController.setGameState(gameState);
		}
	}
	if(gameState === 2){
		if(i_dim_black.mouseInside(mousePosition)){

		}

		// scanner
		if(activeAreaIndex === 0){

		}else if(i_scanner.mouseInside(mousePosition) === false
			&& !(b_buy_melee.mouseInside(mousePosition) || b_buy_ranged.mouseInside(mousePosition) || b_buy_aoe.mouseInside(mousePosition))
		){
			activeAreaIndex = 0;
		}
		if(i_scanner.mouseInside(mousePosition)){
			if(b_invenButton_top.mouseInside(mousePosition)){
				b_invenButton_top.setClicked(true);
				b_invenButton_middle.setClicked(false);
				b_invenButton_bottom.setClicked(false);
			}else if(b_invenButton_middle.mouseInside(mousePosition)){
				b_invenButton_top.setClicked(false);
				b_invenButton_middle.setClicked(true);
				b_invenButton_bottom.setClicked(false);
			}else if(b_invenButton_bottom.mouseInside(mousePosition)){
				b_invenButton_top.setClicked(false);
				b_invenButton_middle.setClicked(false);
				b_invenButton_bottom.setClicked(true);
			}else{
				if(mouseInScannerRadius()){
					if(b_invenButton_top.isClicked() && inventory.melee > 0){
						GameController.placeUnit("melee", activeAreaIndex, scannerToGameCoodinate(scannerMousePosition));
						inventory.melee -= 1;
					}else if(b_invenButton_middle.isClicked() && inventory.ranged > 0){
						GameController.placeUnit("ranged", activeAreaIndex, scannerToGameCoodinate(scannerMousePosition));
						inventory.ranged -= 1;
					}else if(b_invenButton_bottom.isClicked() && inventory.aoe > 0){
						GameController.placeUnit("aoe", activeAreaIndex, scannerToGameCoodinate(scannerMousePosition));
						inventory.aoe -= 1;
					}
				}
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

		// shop
		if(b_buy_melee.mouseInside(mousePosition) && money >= buyMeleeCost){
			b_buy_melee.setClicked(true);
			GameController.buyUnit("melee");
		}else{
			b_buy_melee.setClicked(false);
		}
		if(b_buy_ranged.mouseInside(mousePosition) && money >= buyRangedCost){
			b_buy_ranged.setClicked(true);
			GameController.buyUnit("ranged");
		}else{
			b_buy_ranged.setClicked(false);
		}
		if(b_buy_aoe.mouseInside(mousePosition) && money >= buyAoeCost){
			b_buy_aoe.setClicked(true);
			GameController.buyUnit("aoe");
		}else{
			b_buy_aoe.setClicked(false);
		}

		// time
		if(b_time_pause.mouseInside(mousePosition)){
			GameController.setSpeedMultiplier("pause");
		}
		if(b_time_play.mouseInside(mousePosition)){
			GameController.setSpeedMultiplier("play");
		}
		if(b_time_fastforward.mouseInside(mousePosition)){
			GameController.setSpeedMultiplier("fastforward");
		}
		if(b_time_slowdown.mouseInside(mousePosition)){
			GameController.setSpeedMultiplier("slowdown");
		}
		b_time_pause.setClicked(b_time_pause.mouseInside(mousePosition));
		b_time_play.setClicked(b_time_play.mouseInside(mousePosition));
		b_time_fastforward.setClicked(b_time_fastforward.mouseInside(mousePosition));
		b_time_slowdown.setClicked(b_time_slowdown.mouseInside(mousePosition));
	}
}

function getMousePosition(canvas : HTMLCanvasElement, e : MouseEvent){
	var canvasRect = canvas.getBoundingClientRect();
	mousePosition = {x: e.clientX - canvasRect.left, y: e.clientY - canvasRect.top} as Vector2;
	scannerMousePosition = {x: e.clientX - canvasRect.left - Config.SCANNER_CENTER.x, y: e.clientY - canvasRect.top - Config.SCANNER_CENTER.y} as Vector2;

	

	return mousePosition;
}

function scannerToCanvasCoordinate(coordinate : Vector2){
	var canvasRect = canvas!.getBoundingClientRect();
	return {x: coordinate.x + Config.SCANNER_CENTER.x, y: coordinate.y + Config.SCANNER_CENTER.y} as Vector2
}

function canvasToScannerCoordinate(coordinate : Vector2){
	var canvasRect = canvas!.getBoundingClientRect();
	return {x: coordinate.x - canvasRect.left - Config.SCANNER_CENTER.x, y: coordinate.y - canvasRect.top - Config.SCANNER_CENTER.y} as Vector2
}

function scannerToGameCoodinate(coordinate : Vector2){
	var scale = scannerRadius/Config.SCANNER_RADIUS;
	var v = Vector2.getCopy(coordinate);
	v.scale(scale);
	return v;
}

function mouseInScannerRadius(){
	return Vector2.distanceBetweenPoint(new Vector2(0,0), scannerMousePosition) <= Config.SCANNER_RADIUS;
}

