package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.validator.UsuarioAmizadeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeletarAmizadeServiceTest {
    @Mock
    AmizadeRepository repository;
    @Mock
    BuscarAmizadePorAmigoEUsuario buscarAmizadePorAmigoEUsuario;
    @Mock
    UsuarioAmizadeValidator validator;
    @InjectMocks
    DeletarAmizadeService deletarAmizadeService;


    @Test
    public void deveDeletarAmizade()  {
        Amizade amizade = new Amizade();
        UserPrincipal userPrincipal = new UserPrincipal(1L, null, null, null, null, null, null);

        when(repository.findParaDeletar(anyLong(), anyLong())).thenReturn(amizade);

        deletarAmizadeService.deletar(1L, userPrincipal);
    }
}
