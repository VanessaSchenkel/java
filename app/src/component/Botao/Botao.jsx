import React, { Component } from 'react';
import './style.css';

export class Botao extends Component {
	render() {
		return <button className="botao">{this.props.text}</button>;
	}
}
