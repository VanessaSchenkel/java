import React, { Component } from 'react';
import { PostagemCard } from '../PostagemCard/PostagemCard';
import api from '../../api/index';
import './style.css';
import { Container } from 'semantic-ui-react';

export class Posts extends Component {
	state = {
		lista: []
	};

	componentDidMount = async () => {
		const response = await api.get('/postagens/todas');
		this.setState({
			lista: response.data.content
		});
	};

	renderPosts = () => {
		return this.state.lista.map((post, key) => (
			<PostagemCard
				key={key}
				data={post.data}
				foto={post.foto}
				id={post.id}
				numeroCurtidas={post.numeroCurtidas}
				texto={post.texto}
				nomeCompleto={post.usuario.nomeCompleto}
			/>
		));
	};

	render() {
		console.log(this.state.lista);

		return (
			<Container>
				<div className="card-postagem">
					<h3 className="solicitacoes-titulo">Postagens</h3>
					{this.renderPosts()}
				</div>
			</Container>
		);
	}
}
