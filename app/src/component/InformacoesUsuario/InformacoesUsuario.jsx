import React, { Component } from 'react';
import './style.css';
import api from '../../api/index';
import { Image, Container } from 'semantic-ui-react';

export class InformacoesUsuario extends Component {
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

	componentDidMount = async () => {
		await api.get('/usuarios/minhas-informacoes').then((response) =>
			this.setState({
				nomeCompleto: response.data.nomeCompleto,
				apelido: response.data.apelido,
				email: response.data.email,
				dataNascimento: response.data.dataNascimento,
				imagemPerfil: response.data.imagemPerfil,
				paisOrigem: response.data.paisOrigem,
				paisAtual: response.data.paisAtual
			})
		);
	};

	render() {
		return (
			<div className="info">
				<Container>
					<Image src={this.state.imagemPerfil} size="small" avatar />
					<p className="nome-completo">
						<strong>{this.state.nomeCompleto}</strong>
					</p>
					<p>Apelido: {this.state.apelido}</p>
					<p>E-mail: {this.state.email}</p>
					<p>Data de nascimento: {this.state.dataNascimento}</p>
					<p>País de origem: {this.state.paisOrigem}</p>
					<p>País atual: {this.state.paisAtual}</p>
				</Container>
			</div>
		);
	}
}
