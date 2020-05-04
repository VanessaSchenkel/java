package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificaSeJaTemAmizadeService {

    @Autowired
    AmizadeRepository repository;

    public boolean amizadeJaExiste(Long idSolicitando, Long idSolicitado){
        return repository.existsByUsuarioSolicitanteIdAndUsuarioSolicitadoId(idSolicitando, idSolicitado);
    }
}
