package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarAmizadePorAmigoEUsuario {

    @Autowired
    AmizadeRepository repository;

    public Amizade buscar(Long idUsuario, Long idAmigo){
        return repository.findByUsuarioSolicitadoESolicitante(idUsuario, idAmigo);
    }

}
