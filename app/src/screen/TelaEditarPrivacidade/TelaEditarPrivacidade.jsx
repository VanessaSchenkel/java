import React, { Component, Fragment } from 'react';
import MenuPrincipal from '../../component/MenuPrincipal/MenuPrincipal';
import { EditarPrivacidade } from '../../component/EditarPrivacidade/EditarPrivacidade';

export class TelaEditarPrivacidade extends Component {
	render() {
		return (
			<Fragment>
				<MenuPrincipal />
				<EditarPrivacidade />
			</Fragment>
		);
	}
}
