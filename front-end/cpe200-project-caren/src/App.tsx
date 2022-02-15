import React from 'react';
import './App.css';
import ImageObject from './ImageObject';

import p_main_background from './assets/artworks/main_background.png'
import p_dim_black from './assets/artworks/dim_black.png'
import p_alertLight_blue from './assets/artworks/alertLight_blue.png'
import TextObject from './TextObject';

var canvas : HTMLCanvasElement | null;
var ctx: CanvasRenderingContext2D | null;
var main_background: ImageObject;
var dim_black : ImageObject;
var alertLight_blue: ImageObject;

var t_caren : TextObject;
var t_howToPlay : TextObject;
var t_clickAnywhereToStart : TextObject;

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
		this.interval = setInterval(() => this.setState({ time: Date.now() }), 1000);
		
		this.initAll();
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
		
		ctx = canvas!.getContext('2d')
		ctx!.scale(imageScaling,imageScaling);


		main_background = new ImageObject(p_main_background,0,0)
		dim_black = new ImageObject(p_dim_black, 0,0);
		alertLight_blue = new ImageObject(p_alertLight_blue,0,0)

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

	}

	
	updateAll(){
		if(DEBUG) console.log("UPDATEALL")
		ctx!.clearRect(0,0,screenWidth, screenHeight);
	}

	drawAll(){
		main_background.draw();
		dim_black.draw();

		t_caren.draw();
		t_howToPlay.draw();
		t_clickAnywhereToStart.draw();
	}

	draw(img : ImageObject){
		if(DEBUG) console.log('draw');
		ctx!.drawImage(img.image, img.position.x, img.position.y, img.width, img.height);
	}

	render() {
		return (
			<canvas></canvas>
		)
	}
}

export default App;


