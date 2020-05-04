package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarCurtidaPorPostagemIDEUsuarioIDService {

    @Autowired
    CurtidaRepository repository;

    public Curtida buscar(Long idPostagem, Long idUsuario){
        return repository.findByPostagemUsuarioCurtidor(idPostagem, idUsuario)
                .orElseThrow(() -> new ValidacaoAplicacaoException("Curtida não entrada"));
    }

}
