import React from 'react';
import logo from './logo.svg';
import './App.css';

class App extends React.Component {

	constructor(props : any) {
		super(props);
	}

	componentDidMount() { // <2>
		console.log("MOUNTED");
	}

	render() {
		return (
			"Project configured correctly!"
		)
	}
}

export default App;