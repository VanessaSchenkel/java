package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAmizadeValidator {

    public void validar(Amizade amizade, Long idSolicitado){
        if(!amizade.getUsuarioSolicitado().getId().equals(idSolicitado)){
            throw new ValidacaoAplicacaoException("Não é usuário solicitado.");
        }
    }
}
