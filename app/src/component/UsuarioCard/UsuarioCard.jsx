import React, { Component } from 'react';
import './style.css';
import api from '../../api/index';
import { Image, Button } from 'semantic-ui-react';

export class UsuarioCard extends Component {
	constructor(props) {
		super(props);
		this.state = {
			idUsuario: props.id
		};
	}

	handleSubmitAceitar = async (e) => {
		e.preventDefault();

		const { idUsuario } = this.state;

		try {
			await api.put(`amizades/solicitacoes/${idUsuario}`);

			alert('Amigo aceito com sucesso!');
			this.setState({
				id: ''
			});
		} catch (error) {
			alert('Erro');
		}
	};

	render() {
		return (
			<div>
				<div className="card-usuario">
					<Image
						src={this.props.image}
						className="imagem-solicitacao"
						alt={this.props.image}
						size="tiny"
						fluid="true"
					/>
					<div className="name">{this.props.name}</div>
				</div>
				<Button primary onClick={this.handleSubmitAceitar}>
					{this.props.acaoPositiva}
				</Button>
				<Button secondary onClick={this.handleSubmitRecusar}>
					{this.props.acaoNegativa}
				</Button>
			</div>
		);
	}
}

export default UsuarioCard;
