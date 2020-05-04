import React, { Component } from 'react';
import { PostagemCard } from '../PostagemCard/PostagemCard';
import api from '../../api/index';
import { Container, Button, Image } from 'semantic-ui-react';

export class EditarPrivacidade extends Component {
	state = {
		lista: [],
		privado: '',
		id: ''
	};

	componentDidMount = async () => {
		const response = await api.get('/postagens/minhas-postagens');
		this.setState({
			lista: response.data.content
		});
	};

	handleInputChange = (e) => {
		this.setState({ [e.target.name]: e.target.value });
	};

	handleSubmit = async () => {
		const { privado, id } = this.state;

		const body = {
			privado
		};

		try {
			await api.put(`/postagens/mudar-privacidade/${id}`);
			alert('Privacidade mudada com sucesso!');
		} catch (error) {
			alert('Erro');
		}
	};

	mudarId = (id) => {
		this.setState({
			id
		});
		this.handleSubmit();
	};

	renderPosts = () => {
		return this.state.lista.map((post, key) => (
			<div>
				<div className="postagens-container">
					<Image src={post.foto} alt={post.foto} size="massive" />
					<div className="post">
						<div className="data-post">{post.data}</div>
						<div className="texto">{post.texto}</div>
					</div>
					<select name="privado" onChange={this.handleInputChange}>
						<option value={true}>PRIVADO</option>
						<option value={false}>PÚBLICO</option>
					</select>
					<Button onClick={() => this.mudarId(post.id)}>Enviar</Button>
				</div>
			</div>
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
