import React, { Component } from 'react';
import { Menu } from 'semantic-ui-react';
import './style.css';

export default class MenuPrincipal extends Component {
	state = {};

	handleItemClick = (e, { name }) => this.setState({ activeItem: name });

	render() {
		const { activeItem } = this.state;

		return (
			<Menu>
				<Menu.Item
					name="Meu perfil"
					active={activeItem === 'editorials'}
					onClick={this.handleItemClick}
					href="/bemvindo"
				>
					Principal
				</Menu.Item>

				<Menu.Item
					name="editarInfo"
					active={activeItem === 'editarInfo'}
					onClick={this.handleItemClick}
					href="/editarInfo"
				>
					Editar minhas informações
				</Menu.Item>

				<Menu.Item
					name="buscarUsuario"
					active={activeItem === 'buscarUsuario'}
					onClick={this.handleItemClick}
					href="/buscar"
				>
					Buscar usuário
				</Menu.Item>
				<Menu.Item
					name="listaAmigos"
					active={activeItem === 'listaAmigos'}
					onClick={this.handleItemClick}
					href="/lista-de-amigos"
				>
					Ver lista de amigos
				</Menu.Item>
				<Menu.Item
					name="editarPrivacidade"
					active={activeItem === 'editarPrivacidade'}
					onClick={this.handleItemClick}
					href="/editar-privacidade"
				>
					Editar privacidade das minhas postagens
				</Menu.Item>

				<div className="mi-amigo">Mi amigo su amigo</div>
				<img src="https://image.flaticon.com/icons/svg/1189/1189191.svg" className="logo" />
			</Menu>
		);
	}
}
