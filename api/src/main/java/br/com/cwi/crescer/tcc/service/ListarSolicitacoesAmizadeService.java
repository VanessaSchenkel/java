package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarSolicitacoesAmizadeService {

    @Autowired
    AmizadeRepository repository;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    @Autowired
    private BuscarListaSolicitacoesAmizadeService buscarListaSolicitacoesAmizadeService;

    public List<Usuario> listar(UserPrincipal usuario){
        return buscarListaSolicitacoesAmizadeService.buscarListaPorIdUsuario(usuario.getId());
    }
}
