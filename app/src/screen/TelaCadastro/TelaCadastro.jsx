import React, { Component } from 'react';
import api from '../../api/index';
import './style.css';
import { Redirect } from 'react-router-dom';
import { Container, Button, Input } from 'semantic-ui-react';

export class TelaCadastro extends Component {
	state = {
		nomeCompleto: '',
		apelido: '',
		email: '',
		senha: '',
		dataNascimento: '',
		imagemPerfil: '',
		paisOrigem: '',
		paisAtual: '',
		irParaDashboard: false
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

		const login = {
			email,
			senha
		};

		try {
			await api.post('/usuarios', body);
			alert('Cadastro realizado com sucesso!');
			this.setState({
				irParaDashboard: true
			});

			const retorno = await api.post('/public/autenticacao/login', login);

			localStorage.setItem('token', retorno.data.accessToken);
		} catch (error) {
			alert('Usuário não foi cadastrado');
		}
	};

	renderRedirect = () => {
		if (this.state.irParaDashboard) {
			return <Redirect to="/bemvindo" />;
		}
	};

	render() {
		const { nomeCompleto, apelido, email, senha, dataNascimento, imagemPerfil, paisOrigem, paisAtual } = this.state;

		return (
			<Container>
				<div className="container-tela-cadastro">
					{this.renderRedirect()}
					<form class="tela-cadastro" onSubmit={this.handleSubmit}>
						<h1>Cadastro</h1>

						<label>Nome completo</label>
						<Input
							type="text"
							placeholder="Ex.: Jonlenau Silva"
							name="nomeCompleto"
							value={nomeCompleto}
							onChange={this.handleInputChange}
						/>

						<label>Apelido</label>
						<Input
							type="text"
							placeholder="Ex.: Jonjon"
							name="apelido"
							value={apelido}
							onChange={this.handleInputChange}
						/>

						<label>Email</label>
						<Input
							type="email"
							placeholder="Ex.: amoosbeatles@john.com"
							name="email"
							value={email}
							onChange={this.handleInputChange}
						/>

						<label>Senha</label>
						<Input
							type="password"
							placeholder="Ex.: 123456"
							name="senha"
							value={senha}
							onChange={this.handleInputChange}
						/>

						<label>Data de nascimento</label>
						<Input
							type="date"
							placeholder="AAAA-MM-DD"
							name="dataNascimento"
							value={dataNascimento}
							onChange={this.handleInputChange}
						/>

						<label>URL da imagem de perfil</label>
						<Input
							type="text"
							placeholder="Ex.: www.olhaeu.com.br"
							name="imagemPerfil"
							value={imagemPerfil}
							onChange={this.handleInputChange}
						/>

						<label>País de origem</label>
						<Input
							type="text"
							placeholder="Ex.: Brasil"
							name="paisOrigem"
							value={paisOrigem}
							onChange={this.handleInputChange}
						/>

						<label>País atual</label>
						<Input
							type="text"
							placeholder="Ex.: França"
							name="paisAtual"
							value={paisAtual}
							onChange={this.handleInputChange}
						/>

						<Button onClick={this.handleSubmit}>Me cadastrar</Button>
					</form>
				</div>
			</Container>
		);
	}
}
