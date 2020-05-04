import React, { Component, Fragment } from 'react';
import MenuPrincipal from '../../component/MenuPrincipal/MenuPrincipal';
import { BuscarUsuario } from '../../component/BuscarUsuario/BuscarUsuario';

export class TelaBuscarUsuario extends Component {
	render() {
		return (
			<Fragment>
				<MenuPrincipal />
				<BuscarUsuario />
			</Fragment>
		);
	}
}
