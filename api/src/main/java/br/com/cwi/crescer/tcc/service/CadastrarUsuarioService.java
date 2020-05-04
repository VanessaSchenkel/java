package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.mapper.UsuarioMapper;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.validator.JaPossuiCadastroValidator;
import br.com.cwi.crescer.tcc.validator.UsuarioValidator;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private UsuarioValidator validator;

    @Autowired
    private JaPossuiCadastroValidator jaPossuiCadastroValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(UsuarioRequest request){
        Usuario usuario = UsuarioMapper.transformar(request);

        validator.validar(usuario);
        jaPossuiCadastroValidator.validar(usuario);

        usuario.setAtivo(true);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        return repository.save(usuario);
    }

}
