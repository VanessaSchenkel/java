import React, { Component } from 'react';
import './style.css';
import { Image, Button } from 'semantic-ui-react';
import { Comentario } from '../Comentario/Comentario';
import { ListarComentarios } from '../ListarComentarios/ListarComentarios';

export class PostagemCard extends Component {
	constructor(props) {
		super(props);
		this.state = {
			idUsuario: props.id,
			n: props.numeroCurtidas
		};
	}

	render() {
		return (
			<div className="postagens-container">
				<h4>
					<strong>{this.props.nomeCompleto}</strong>
				</h4>
				<Image src={this.props.foto} alt={this.props.foto} size="massive" />
				<div className="post">
					<div className="data-post">{this.props.data}</div>
					<div className="numero-curtidas">{this.state.n} curtidas</div>
					<div className="texto">{this.props.texto}</div>
				</div>
				<div className="comentario-postagem">
					<ListarComentarios id={this.props.id} />
					<Comentario id={this.props.id} />
				</div>
			</div>
		);
	}
}

export default PostagemCard;
