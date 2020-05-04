import React, { Component } from 'react';
import api from '../../api/index';
import './style.css';
import { Form, Radio, Button, Input, TextArea } from 'semantic-ui-react';

export class Comentario extends Component {
	constructor(props) {
		super(props);
		this.state = {
			id: props.id,
			texto: ''
		};
	}

	handleInputChange = (e) => {
		this.setState({ [e.target.name]: e.target.value });
	};

	handleSubmit = async (e) => {
		e.preventDefault();

		const { texto, id } = this.state;

		const body = {
			texto
		};

		try {
			await api.post(`/comentarios/${id}`, body);
			alert('Comentario criado com sucesso com sucesso!');
			this.setState({
				texto: ''
			});
		} catch (error) {
			alert('Erro');
		}
	};

	handleCurtir = async (e) => {
		e.preventDefault();

		const { id } = this.state;

		try {
			await api.post(`curtidas/${id}`);
			alert('curtida!');
		} catch (error) {
			alert('Erro');
		}
	};

	handleDescurtir = async (e) => {
		e.preventDefault();

		const { id } = this.state;

		try {
			await api.delete(`curtidas/${id}`);
			alert('descurtida!');
		} catch (error) {
			alert('Erro');
		}
	};

	render() {
		const { texto, id } = this.state;

		return (
			<div>
				<div className="container-novo-comentario">
					<h5>Comentar: </h5>
					<Form>
						<label>Texto (obrigatório): </label>
						<TextArea
							placeholder="Ex.: Mas bá tche tri legal"
							name="texto"
							value={texto}
							onChange={this.handleInputChange}
						/>
					</Form>
					<Button color="blue" onClick={this.handleSubmit}>
						Enviar
					</Button>
				</div>
				<div className="curtir-postagem">
					<Button color="green" onClick={this.handleCurtir}>
						Curtir
					</Button>
					<Button onClick={this.handleDescurtir}>Descurtir</Button>
				</div>
			</div>
		);
	}
}
