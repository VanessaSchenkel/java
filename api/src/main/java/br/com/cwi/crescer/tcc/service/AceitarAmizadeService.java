package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AceitarAmizadeService {

    @Autowired
    private AmizadeRepository repository;

    @Autowired
    private BuscarAmizadePorAmigoEUsuario buscarAmizadePorAmigoEUsuario;


    public void aceitar(UserPrincipal user, Long idAmigo ){
            Amizade amizade = buscarAmizadePorAmigoEUsuario.buscar(user.getId(), idAmigo);

            amizade.setAceitado(true);

            repository.save(amizade);

    }
}
