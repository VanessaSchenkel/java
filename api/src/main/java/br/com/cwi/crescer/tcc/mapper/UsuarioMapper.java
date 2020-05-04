package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;

public class UsuarioMapper {

    public static Usuario transformar(final UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setApelido(request.getApelido());
        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setPaisAtual(request.getPaisAtual());
        usuario.setPaisOrigem(request.getPaisOrigem());
        usuario.setImagemPerfil(request.getImagemPerfil());

        return usuario;
    }


}
