package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorIDService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoAplicacaoException("Usuário não encontrado :("));
    }

}
