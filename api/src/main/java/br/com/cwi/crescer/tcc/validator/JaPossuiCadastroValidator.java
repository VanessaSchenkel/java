package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JaPossuiCadastroValidator {

    @Autowired
    private UsuarioRepository repository;

    public void validar(Usuario usuario) {
        if (repository.existsByEmail(usuario.getEmail())) {
            throw new ValidacaoNegocioException("Esse e-mail já foi cadastrado. ");
        }
    }
}


