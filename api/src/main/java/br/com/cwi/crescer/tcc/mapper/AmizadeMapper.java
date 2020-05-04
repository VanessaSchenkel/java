package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.domain.Usuario;

import java.time.LocalDate;

public class AmizadeMapper {

    public static Amizade transformar(final Usuario amigo, Usuario solicitante){
        Amizade amizade = new Amizade();

        amizade.setUsuarioSolicitante(solicitante);
        amizade.setUsuarioSolicitado(amigo);
        amizade.setDataAmizade(LocalDate.now());
        amizade.setAceitado(false);

        return amizade;
    }


}
