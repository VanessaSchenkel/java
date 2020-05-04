import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import { TelaInicial } from '../src/screen/TelaInicial/TelaInicial';
import { TelaCadastro } from '../src/screen/TelaCadastro/TelaCadastro';
import { TelaBemVindo } from './screen/TelaBemVindo/TelaBemVindo';
import { TelaEditarInfo } from './screen/TelaEditarInfo/TelaEditarInfo';
import { TelaBuscarUsuario } from './screen/TelaBuscarUsuario/TelaBuscarUsuario';
import { TelaPerfilUsuario } from './screen/TelaPerfilUsuario/TelaPerfilUsuario';
import { TelaListarAmigos } from './screen/TelaListarAmigos/TelaListarAmigos';
import { TelaEditarPrivacidade } from './screen/TelaEditarPrivacidade/TelaEditarPrivacidade';

export default function App() {
	return (
		<Switch>
			<Route path="/" component={TelaInicial} exact />
			<Route path="/cadastro" component={TelaCadastro} />
			<Route path="/bemvindo" component={TelaBemVindo} />
			<Route path="/editarInfo" component={TelaEditarInfo} />
			<Route path="/buscar" component={TelaBuscarUsuario} />
			<Route path="/usuario/:idUsuario" component={TelaPerfilUsuario} />
			<Route path="/lista-de-amigos" component={TelaListarAmigos} />
			<Route path="/editar-privacidade" component={TelaEditarPrivacidade} />
		</Switch>
	);
}
