import React, { Component } from 'react';
import api from '../../api/index';
import './style.css';
import { Container, Button, Comment, Image } from 'semantic-ui-react';

export class ListarComentarios extends Component {
	constructor(props) {
		super(props);
		this.state = {
			id: props.id,
			lista: []
		};
	}

	handleSubmit = async (e) => {
		e.preventDefault();

		const { id } = this.state;

		try {
			const response = await api.get(`/comentarios/${id}`);
			this.setState({
				lista: response.data
			});
		} catch (error) {
			alert('Erro');
		}
	};

	renderComentarios = () => {
		return this.state.lista.map((post, key) => (
			<Comment>
				<Image src={post.usuario.imagemPerfil} size="tiny" />
				<Comment.Content>
					<Comment.Author as="a">{post.usuario.nomeCompleto}</Comment.Author>
					<Comment.Metadata>
						<div>{post.data}</div>
					</Comment.Metadata>
					<Comment.Text>{post.texto}</Comment.Text>
				</Comment.Content>
			</Comment>
		));
	};

	render() {
		console.log(this.state.lista);

		return (
			<Container>
				<Button onClick={this.handleSubmit}>Mostrar comentários</Button>
				<div className="comentarios">{this.renderComentarios()}</div>
			</Container>
		);
	}
}
