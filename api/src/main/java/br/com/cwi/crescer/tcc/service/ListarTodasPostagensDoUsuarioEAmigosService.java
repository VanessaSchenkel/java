package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarTodasPostagensDoUsuarioEAmigosService {

    @Autowired
    PostagemRepository repository;

    public Page<Postagem> buscar(Long idUsuario, Pageable pageable){

        return repository.findAllPostsFromUserAndFriends(idUsuario, pageable);
    }
}
