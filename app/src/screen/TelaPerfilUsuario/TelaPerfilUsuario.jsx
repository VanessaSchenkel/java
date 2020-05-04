import React, { Component, Fragment } from 'react';
import MenuPrincipal from '../../component/MenuPrincipal/MenuPrincipal';
import { UsuarioPerfil } from '../../component/UsuarioPerfil/UsuarioPerfil';

export class TelaPerfilUsuario extends Component {
	render() {
		return (
			<Fragment>
				<MenuPrincipal />
				<UsuarioPerfil user={this.props.match.params.idUsuario} />
			</Fragment>
		);
	}
}
