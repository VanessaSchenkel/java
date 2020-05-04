import React, { Component, Fragment } from 'react';
import './style.css';
import { Link } from 'react-router-dom';
import MenuPrincipal from '../../component/MenuPrincipal/MenuPrincipal';
import { InformacoesUsuario } from '../../component/InformacoesUsuario/InformacoesUsuario';
import { SolicitacoesDeAmizade } from '../../component/SolicitacoesAmizade/SolicitacoesAmizade';
import { FormularioPost } from '../../component/FormularioPost/FormularioPost';
import { Posts } from '../../component/Posts/Posts';

export class TelaBemVindo extends Component {
	render() {
		return (
			<Fragment>
				<MenuPrincipal />
				<InformacoesUsuario />
				<SolicitacoesDeAmizade />
				<FormularioPost />
				<Posts />
			</Fragment>
		);
	}
}
