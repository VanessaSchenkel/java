package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostagensDoUsuarioService {
    @Autowired
    BuscarPostagensDoUsuarioService buscarPostagensDoUsuarioService;

    public Page<Postagem> listar(Long idUsuario, Pageable pageable){

        Pageable page = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort());

        return buscarPostagensDoUsuarioService.buscar(idUsuario, page);
    }

}
