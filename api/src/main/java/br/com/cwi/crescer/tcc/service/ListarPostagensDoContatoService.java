package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostagensDoContatoService {
    @Autowired
    BuscarPostagensDoUsuarioService buscarPostagensDoUsuarioService;

    @Autowired
    AmizadeRepository amizadeRepository;

    public Page<Postagem> listar(Long idAmigo, Pageable pageable){
        return buscarPostagensDoUsuarioService.buscar(idAmigo, pageable);
    }
}
