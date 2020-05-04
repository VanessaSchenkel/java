package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.web.request.PostagemRequest;

import java.time.LocalDate;

public class PostagemMapper {

    public static Postagem transformar(PostagemRequest request, Usuario usuario){
        Postagem postagem = new Postagem();

        postagem.setUsuario(usuario);
        postagem.setTexto(request.getTexto());
        postagem.setFoto(request.getFoto());
        postagem.setPrivado(request.isPrivado());
        postagem.setData(LocalDate.now());
        postagem.setNumeroCurtidas(0);

        return postagem;

    }
}
