import React from 'react';
import './App.css';
import ImageObject from './ImageObject';

import main_background from './assets/artworks/main_background.png'
import alertLight_blue from './assets/artworks/alertLight_blue.png'

var canvas;
var ctx;
var background ;
var alertLightBlue;

const screenWidth = 1280;
const screenHeight = 720;

console.log("top");

class App extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
		console.log("MOUNTED");
		this.interval = setInterval(() => this.setState({ time: Date.now() }), 1000);
		
		this.initAll();
		this.updateAll();
	}

	componentDidUpdate(){
		this.updateAll();
	}

	componentWillUnmount(){
		clearInterval(this.interval);
	}

	initAll(){
		console.log("INITALL")
		canvas = document.querySelector('canvas');
		canvas.width = 1280
		canvas.height = 720
		
		ctx = canvas.getContext('2d')


		background = new ImageObject(0,0,screenWidth,screenHeight,main_background)
		alertLightBlue = new ImageObject(0,0,100,100,alertLight_blue)

		console.log(background)
		console.log(alertLightBlue)
	}

	
	updateAll(){
		console.log("UPDATEALL")
		ctx.clearRect(0,0,screenWidth, screenHeight);

		this.draw(ctx, background)
		this.draw(ctx, alertLightBlue)
	}

	draw(ctx, img){
		ctx.drawImage(img.image, img.position.x, img.position.y, img.width, img.height);
	}

	render() {
		return (
			<canvas></canvas>
		)
	}
}

export default App;


