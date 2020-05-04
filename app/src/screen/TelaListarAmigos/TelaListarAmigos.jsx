import React, { Component, Fragment } from 'react';
import MenuPrincipal from '../../component/MenuPrincipal/MenuPrincipal';
import { Container } from 'semantic-ui-react';
import { ListaDeAmigos } from '../../component/ListaDeAmigos/ListaDeAmigos';

export class TelaListarAmigos extends Component {
	render() {
		return (
			<Fragment>
				<MenuPrincipal />
				<Container>
					<ListaDeAmigos />
				</Container>
			</Fragment>
		);
	}
}
