import React, { Component } from 'react';
import api from '../../api/index';
import './style.css';
import { Button, Container, Input } from 'semantic-ui-react';

export class EditarInfoUsuario extends Component {
	state = {
		nomeCompleto: '',
		apelido: '',
		email: '',
		senha: '',
		dataNascimento: '',
		imagemPerfil: '',
		paisOrigem: '',
		paisAtual: ''
	};

	componentDidMount = async () => {
		await api.get('/usuarios/minhas-informacoes').then((response) =>
			this.setState({
				nomeCompleto: response.data.nomeCompleto,
				apelido: response.data.apelido,
				email: response.data.email,
				dataNascimento: response.data.dataNascimento,
				imagemPerfil: response.data.imagemPerfil,
				paisOrigem: response.data.paisOrigem,
				paisAtual: response.data.paisAtual,
				senha: response.data.senha
			})
		);
	};

	handleInputChange = (e) => {
		this.setState({ [e.target.name]: e.target.value });
	};

	handleSubmit = async (e) => {
		e.preventDefault();

		const { nomeCompleto, apelido, email, senha, dataNascimento, imagemPerfil, paisOrigem, paisAtual } = this.state;

		const body = {
			apelido,
			dataNascimento,
			email,
			imagemPerfil,
			nomeCompleto,
			paisAtual,
			paisOrigem,
			senha
		};

		try {
			await api.put('/usuarios', body);
			alert('Perfil editado com sucesso!');
		} catch (error) {
			alert('Usuário não foi cadastrado');
		}
	};

	render() {
		const { nomeCompleto, apelido, email, senha, dataNascimento, imagemPerfil, paisOrigem, paisAtual } = this.state;

		return (
			<div className="info">
				<Container>
					<form class="cadastro" onSubmit={this.handleSubmit}>
						<h1>Editar cadastro</h1>

						<label>Nome completo</label>
						<Input
							type="text"
							placeholder="Ex.: Jonlenau Silva"
							name="nomeCompleto"
							value={this.state.nomeCompleto}
							onChange={this.handleInputChange}
						/>

						<label>Apelido</label>
						<Input
							type="text"
							placeholder="Ex.: Jonjon"
							name="apelido"
							value={this.state.apelido}
							onChange={this.handleInputChange}
						/>

						<label>URL da imagem de perfil</label>
						<Input
							type="text"
							placeholder="Ex.: www.olhaeu.com.br"
							name="imagemPerfil"
							value={this.state.imagemPerfil}
							onChange={this.handleInputChange}
						/>

						<label>País de origem</label>
						<Input
							type="text"
							placeholder="Ex.: Brasil"
							name="paisOrigem"
							value={this.state.paisOrigem}
							onChange={this.handleInputChange}
						/>

						<label>País atual</label>
						<Input
							type="text"
							placeholder="Ex.: França"
							name="paisAtual"
							value={this.state.paisAtual}
							onChange={this.handleInputChange}
						/>

						<Button className="botao-salvar" onClick={this.handleSubmit}>
							Enviar
						</Button>
					</form>
				</Container>
			</div>
		);
	}
}
