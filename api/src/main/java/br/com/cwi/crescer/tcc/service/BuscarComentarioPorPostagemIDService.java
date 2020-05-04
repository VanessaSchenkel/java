package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarComentarioPorPostagemIDService {

    @Autowired
    ComentarioRepository repository;

    public List<Comentario> buscarPorPostagemId(Long idPostagem){
        return repository.findByPostagemId(idPostagem);
    }

}
