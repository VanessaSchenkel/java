import React, { Component } from 'react';
import api from '../../api/index';
import style from './style.css';
import { Form, Radio, Button, Input, TextArea } from 'semantic-ui-react';

export class FormularioPost extends Component {
	state = {
		texto: '',
		foto: '',
		privado: true
	};

	handleInputChange = (e) => {
		this.setState({ [e.target.name]: e.target.value });
	};

	handleSubmit = async (e) => {
		e.preventDefault();

		const { texto, foto, privado } = this.state;

		const body = {
			texto,
			foto,
			privado
		};

		try {
			await api.post('/postagens', body);
			alert('Post criado com sucesso com sucesso!');
			this.setState({
				texto: '',
				foto: '',
				privado
			});
		} catch (error) {
			alert('Usuário não foi cadastrado');
		}
	};

	render() {
		const { texto, foto, privado } = this.state;

		console.log(this.state.privado);

		return (
			<div className="container-formulario">
				<h3>Nova postagem: </h3>
				<Form>
					<label>Texto (obrigatório): </label>
					<TextArea
						placeholder="Ex.: Sou da ... e quero encontrar pessoas de..."
						name="texto"
						value={texto}
						onChange={this.handleInputChange}
					/>
					<div className="divisao-url">
						<label>URL da imagem</label>
						<Input
							type="text"
							placeholder="Ex.: www.olhaeu.com.br"
							name="foto"
							value={foto}
							onChange={this.handleInputChange}
						/>
					</div>
					<div className="escolha-privacidade">
						<label>Privacidade do post</label>
						<select name="privado" onChange={this.handleInputChange}>
							<option value={true}>PRIVADO</option>
							<option value={false}>PÚBLICO</option>
						</select>
					</div>
				</Form>
				<Button onClick={this.handleSubmit}>Enviar</Button>
			</div>
		);
	}
}
