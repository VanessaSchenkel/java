package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.validator.UsuarioAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarAmizadeService {

    @Autowired
    AmizadeRepository repository;

    @Autowired
    BuscarAmizadePorAmigoEUsuario buscarAmizadePorAmigoEUsuario;

    @Autowired
    UsuarioAmizadeValidator validator;


    public void deletar(Long idAmigo, UserPrincipal user){
            Amizade amizade = repository.findParaDeletar(idAmigo, user.getId());

            if(amizade == null){
                amizade = repository.findParaDeletar(user.getId(), idAmigo);
            }

            repository.deleteById(amizade.getId());
    }
}
