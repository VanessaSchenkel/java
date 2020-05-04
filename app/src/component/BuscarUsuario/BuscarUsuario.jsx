import React, { Component } from 'react';
import api from '../../api/index';
import './style.css';
import { Container, Button, Form, TextArea, FormTextArea, Input, Image, Card, Icon } from 'semantic-ui-react';
import { Link } from 'react-router-dom';

export class BuscarUsuario extends Component {
	constructor(props) {
		super(props);
		this.state = {
			lista: [],
			nomeOuEmail: '',
			deveMostrarResultados: false
		};
	}

	handleSubmit = async (e) => {
		e.preventDefault();

		const { nomeOuEmail } = this.state;

		try {
			const response = await api.get(`/usuarios/buscar/${nomeOuEmail}`);
			this.setState({
				lista: response.data,
				deveMostrarResultados: true
			});
		} catch (error) {
			alert('Erro');
		}
	};

	handleSubmitSolicitar = async (idAmigo) => {
		try {
			await api.post(`amizades/${idAmigo}`);
			alert('Amizade solicitada');
		} catch (error) {
			alert('Erro');
		}
	};

	handleInputChange = (e) => {
		this.setState({ [e.target.name]: e.target.value });
	};

	mostrarResultados = () => {
		if (this.state.deveMostrarResultados) {
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
							<Button primary onClick={() => this.handleSubmitSolicitar(user.id)}>
								Solicitar
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
		}
	};

	render() {
		console.log(this.state.lista);

		return (
			<Container>
				<div className="">
					<h5>Pesquisar: </h5>
					<Form>
						<label>Nome ou email: </label>
						<Input
							placeholder="Ex.: Zezinho"
							name="nomeOuEmail"
							value={this.state.nomeOuEmail}
							onChange={this.handleInputChange}
						/>
					</Form>
					<Button color="blue" onClick={this.handleSubmit}>
						Enviar
					</Button>
					{this.mostrarResultados()}
				</div>
			</Container>
		);
	}
}
