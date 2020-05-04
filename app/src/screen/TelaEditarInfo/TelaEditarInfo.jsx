import React, { Component, Fragment } from 'react';
import MenuPrincipal from '../../component/MenuPrincipal/MenuPrincipal';
import { EditarInfoUsuario } from '../../component/EditarInfoUsuario/EditarInfoUsuario';

export class TelaEditarInfo extends Component {
	render() {
		return (
			<Fragment>
				<MenuPrincipal />
				<EditarInfoUsuario />
			</Fragment>
		);
	}
}
