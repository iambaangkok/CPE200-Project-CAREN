'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {employees: []};
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
// end::app[]

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
