package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.web.request.ComentarioRequest;

import java.time.LocalDate;

public class ComentarioMapper {

    public static Comentario transformar(final Usuario usuario, Postagem postagem, ComentarioRequest request){
        Comentario comentario = new Comentario();

        comentario.setTexto(request.getTexto());
        comentario.setPostagem(postagem);
        comentario.setUsuario(usuario);
        comentario.setData(LocalDate.now());

        return comentario;
    }
}
