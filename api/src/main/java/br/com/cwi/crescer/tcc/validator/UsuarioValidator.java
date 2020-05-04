package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {

    @Autowired
    UsuarioRepository repository;

    public void validar(Usuario usuario){
        if(usuario.getPaisAtual().equals(usuario.getPaisOrigem())){
            throw new ValidacaoNegocioException("Usuário não pode possuir mesmo país de origem e atual. ");
        }
    }
}
