import React, { Component } from 'react';
import api from '../../api/index';
import { Image, Container, Button } from 'semantic-ui-react';
import { useParams } from 'react-router-dom';
import { PostagemCard } from '../../component/PostagemCard/PostagemCard';
import './style.css';

export class UsuarioPerfil extends Component {
	constructor(props) {
		super(props);
		this.state = {
			nomeCompleto: '',
			apelido: '',
			email: '',
			senha: '',
			dataNascimento: '',
			imagemPerfil: '',
			paisOrigem: '',
			paisAtual: '',
			listaPosts: []
		};
	}

	componentDidMount = async () => {
		const response = await api.get(`/usuarios/${this.props.user}`);
		this.setState({
			nomeCompleto: response.data.nomeCompleto,
			apelido: response.data.apelido,
			email: response.data.email,
			dataNascimento: response.data.dataNascimento,
			imagemPerfil: response.data.imagemPerfil,
			paisOrigem: response.data.paisOrigem,
			paisAtual: response.data.paisAtual
		});
		const posts = await api.get(`/postagens/outros/${this.props.user}`);
		this.setState({
			listaPosts: posts.data.content
		});
	};

	renderPosts = () => {
		return this.state.listaPosts.map((post, key) => (
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
		console.log(this.state.listaPosts);

		return (
			<div className="info">
				<Container>
					<div className="conteudo-outro-perfil">
						<Image src={this.state.imagemPerfil} size="small" avatar />
						<p>{this.state.nomeCompleto}</p>
						<p>{this.state.apelido}</p>
						<p>{this.state.email}</p>
						<p>{this.state.dataNascimento}</p>
						<p>{this.state.paisOrigem}</p>
						<p>{this.state.paisAtual}</p>
					</div>

					{this.renderPosts()}
				</Container>
			</div>
		);
	}
}
