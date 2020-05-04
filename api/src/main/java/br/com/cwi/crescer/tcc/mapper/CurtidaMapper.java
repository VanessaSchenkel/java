package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;

import java.time.LocalDate;

public class CurtidaMapper {

    public static Curtida transformar(final Usuario usuario, Postagem postagem){
        Curtida curtida = new Curtida();

        curtida.setData(LocalDate.now());
        curtida.setPostagem(postagem);
        curtida.setUsuarioCurtidor(usuario);

        return curtida;
    }
}
