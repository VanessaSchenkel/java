package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import org.springframework.stereotype.Component;

@Component
public class AmizadeValidator {

    public void validar(Amizade amizade){
        if(usuarioSolicitanteESolicitadoSaoOMesmo(amizade)){
            throw new ValidacaoAplicacaoException("Usuário não pode pedir amizade pra si mesmo");
        }
    }

    private boolean usuarioSolicitanteESolicitadoSaoOMesmo(Amizade amizade) {
        return amizade.getUsuarioSolicitado().getId().equals(amizade.getUsuarioSolicitante().getId());
    }

}
