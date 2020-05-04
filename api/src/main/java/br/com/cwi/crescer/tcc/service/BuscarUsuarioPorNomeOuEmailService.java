package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuscarUsuarioPorNomeOuEmailService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> buscar(String nomeOuEmail){

        return repository.findNomeUsuario(nomeOuEmail);

    }
}
