import React, { Component, Fragment } from 'react';
import './style.css';
import { Link } from 'react-router-dom';
import api from '../../api/index';
import './style.css';
import { Redirect } from 'react-router-dom';
import { Container, Button, Input } from 'semantic-ui-react';

export class TelaInicial extends Component {
	state = {
		email: '',
		senha: '',
		irParaDashboard: false
	};

	handleInputChange = (e) => {
		this.setState({ [e.target.name]: e.target.value });
	};

	handleSubmit = async (e) => {
		e.preventDefault();

		const { email, senha } = this.state;

		const login = {
			email,
			senha
		};

		try {
			const retorno = await api.post('/public/autenticacao/login', login);
			localStorage.setItem('token', retorno.data.accessToken);

			this.setState({
				irParaDashboard: true
			});
		} catch (error) {
			alert('Usuário ou senha errados');
		}
	};

	renderRedirect = () => {
		if (this.state.irParaDashboard) {
			return <Redirect to="/bemvindo" />;
		}
	};

	render() {
		const { email, senha } = this.state;
		return (
			<Container>
				{this.renderRedirect()}

				<div className="tela-principal">
					<img src="https://image.flaticon.com/icons/svg/1189/1189191.svg" className="logo-grande" />

					<h1>
						<strong>MI AMIGO SU AMIGO</strong>
					</h1>
					<h3>Sua comunidade longe de casa</h3>

					<form class="login-tela" onSubmit={this.handleSubmit}>
						<h1>Login</h1>
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

						<Button onClick={this.handleSubmit} className="botao-login">
							Enviar
						</Button>
					</form>
					<div className="lado-esquerdo">
						<Link className="botao" to="/cadastro">
							Não tenho cadastro
						</Link>
					</div>
				</div>
			</Container>
		);
	}
}
