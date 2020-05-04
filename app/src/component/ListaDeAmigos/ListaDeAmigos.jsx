import React, { Component } from 'react';
import { UsuarioCard } from '../UsuarioCard/UsuarioCard';
import api from '../../api/index';
import { Container, Button, Form, TextArea, FormTextArea, Input, Image, Card, Icon } from 'semantic-ui-react';
import { Link } from 'react-router-dom';

export class ListaDeAmigos extends Component {
	state = {
		lista: [],
		idAmigo: ''
	};

	componentDidMount = async () => {
		const response = await api.get('/amizades');
		this.setState({
			lista: response.data.content
		});
	};

	handleSubmitDesfazerAmizade = async (idAmigo) => {
		await api.delete(`/amizades/${idAmigo}`);
	};

	renderUsuarios = () => {
		return this.state.lista.map((user, key) => (
			<div className="card-usuario">
				<Card>
					<Image src={user.imagemPerfil} wrapped ui={false} />
					<Card.Content>
						<Card.Header>{user.nomeCompleto}</Card.Header>
						<Card.Meta>
							<span className="date">Data de nascimento: {user.dataNascimento}</span>
						</Card.Meta>
						<Card.Description>
							Nasceu em {user.paisOrigem}, mas atualmente mora em {user.paisAtual}
						</Card.Description>
						<Button primary onClick={() => this.handleSubmitDesfazerAmizade(user.id)}>
							Desfazer amizade
						</Button>
					</Card.Content>
					<Card.Content extra>
						<Link to={`usuario/${user.id}`} params={{ idUsuario: user.id }}>
							<Icon name="user" />
							Ver perfil
						</Link>
					</Card.Content>
				</Card>
			</div>
		));
	};

	render() {
		console.log(this.state.lista);

		return (
			<div className="card-amizade">
				<h3>Mais que migos, friends</h3>
				{this.renderUsuarios()}
			</div>
		);
	}
}
