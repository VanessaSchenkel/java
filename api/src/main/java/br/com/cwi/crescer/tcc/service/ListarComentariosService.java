package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarComentariosService {

    @Autowired
    private BuscarComentarioPorPostagemIDService buscarComentariosService;

    public List<Comentario> listar(Long idPostagem){
        return buscarComentariosService.buscarPorPostagemId(idPostagem);
    }
}
