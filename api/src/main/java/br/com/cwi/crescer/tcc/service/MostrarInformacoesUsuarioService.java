package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.web.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MostrarInformacoesUsuarioService {

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    public UsuarioResponse mostrar(Long idUsuario){
        Usuario usuario = buscarUsuarioPorIDService.buscarPorId(idUsuario);

        UsuarioResponse response = new UsuarioResponse();

        response.setNomeCompleto(usuario.getNomeCompleto());
        response.setApelido(usuario.getApelido());
        response.setDataNascimento(usuario.getDataNascimento());
        response.setImagemPerfil(usuario.getImagemPerfil());
        response.setEmail(usuario.getEmail());
        response.setPaisAtual(usuario.getPaisAtual());
        response.setPaisOrigem(usuario.getPaisOrigem());
        response.setId(usuario.getId());

        return response;
    }
}
