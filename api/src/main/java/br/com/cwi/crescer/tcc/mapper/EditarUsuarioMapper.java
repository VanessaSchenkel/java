package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;

public class EditarUsuarioMapper {

    public static Usuario editar(UserPrincipal usuario, UsuarioRequest request, Usuario usuarioBuscado) {
        usuarioBuscado.setNomeCompleto(request.getNomeCompleto());
        usuarioBuscado.setApelido(request.getApelido());
        usuarioBuscado.setEmail(request.getEmail());
        usuarioBuscado.setImagemPerfil(request.getImagemPerfil());
        usuarioBuscado.setPaisOrigem(request.getPaisOrigem());
        usuarioBuscado.setPaisAtual(request.getPaisAtual());
        usuario.setDataNascimento(request.getDataNascimento());

        return usuarioBuscado;
    }
}
