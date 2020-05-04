package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarListaSolicitacoesAmizadeService {

    @Autowired
    AmizadeRepository repository;

    public List<Usuario> buscarListaPorIdUsuario(Long idUsuario){
        return repository.listarSolicitacoesDeAmizade(idUsuario);
    }
}
