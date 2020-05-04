package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarAmizadesAceitasService {

    @Autowired
    AmizadeRepository repository;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    public Page<Usuario> buscarListaPorIdUsuario(Long idUsuario, Pageable pageable){
        return repository.listarAmigos(idUsuario, pageable);
    }
}
