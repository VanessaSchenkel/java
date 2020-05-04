package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarAmizadePorIdService {

    @Autowired
    private AmizadeRepository repository;

    public Amizade buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoAplicacaoException("Amizade não foi encontrada"));
    }
}
