package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarPostagemPorIDService {

    @Autowired
    PostagemRepository repository;

    public Postagem buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoAplicacaoException("Postagem não encontrada"));
    }

}
