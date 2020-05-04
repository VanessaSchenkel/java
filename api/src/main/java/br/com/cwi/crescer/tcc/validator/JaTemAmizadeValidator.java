package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.service.VerificaSeJaTemAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JaTemAmizadeValidator {

    @Autowired
    VerificaSeJaTemAmizadeService verificaSeJaTemAmizadeService;

    public void validar(Long idSolicitado, Long idSolicitante){
        if(verificaSeJaTemAmizadeService.amizadeJaExiste(idSolicitado, idSolicitante) || verificaSeJaTemAmizadeService.amizadeJaExiste(idSolicitante, idSolicitado)){
            throw new ValidacaoAplicacaoException("Solicitação já foi feita");
        }

    }
}
