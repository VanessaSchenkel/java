package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.mapper.AmizadeMapper;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.validator.AmizadeValidator;
import br.com.cwi.crescer.tcc.validator.JaTemAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitarAmizadeService {

    @Autowired
    AmizadeRepository repository;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    @Autowired
    AmizadeValidator validator;

    @Autowired
    JaTemAmizadeValidator jaTemAmizadeValidator;


    public Amizade solicitar(Long idAmigo, UserPrincipal usuario){
        Usuario amigo = buscarUsuarioPorIDService.buscarPorId(idAmigo);
        Usuario solicitante = buscarUsuarioPorIDService.buscarPorId(usuario.getId());

        Amizade amizade = AmizadeMapper.transformar(amigo, solicitante);

        validator.validar(amizade);
        jaTemAmizadeValidator.validar(amigo.getId(), solicitante.getId());

        return repository.save(amizade);
    }
}
