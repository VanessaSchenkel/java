package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarPrivacidadePostagemService {

    @Autowired
    PostagemRepository repository;

    @Autowired
    BuscarPostagemPorIDService buscarPostagemPorIDService;

    public void editar(Long idPostagem){
        Postagem postagem = buscarPostagemPorIDService.buscarPorId(idPostagem);

        postagem.setPrivado(!postagem.isPrivado());

        repository.save(postagem);
    }
}
