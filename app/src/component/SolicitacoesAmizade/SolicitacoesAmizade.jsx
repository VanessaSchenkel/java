import React, { Component } from 'react';
import { UsuarioCard } from '../UsuarioCard/UsuarioCard';
import api from '../../api/index';
import './style.css';
import { Container } from 'semantic-ui-react';

export class SolicitacoesDeAmizade extends Component {
	state = {
		lista: []
	};

	componentDidMount = async () => {
		const response = await api.get('/amizades/solicitacoes');
		this.setState({
			lista: response.data
		});
	};

	renderUsuarios = () => {
		return this.state.lista.map((user, key) => (
			<UsuarioCard
				key={key}
				name={user.nomeCompleto}
				image={user.imagemPerfil}
				id={user.id}
				acaoPositiva="Aceitar"
				acaoNegativa="Recusar"
			/>
		));
	};

	render() {
		return (
			<Container>
				<div className="card-amizade">
					<h3>Solicitações de amizade</h3>
					{this.renderUsuarios()}
				</div>
			</Container>
		);
	}
}
