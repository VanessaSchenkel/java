package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AceitarAmizadeServiceTest {
    @Mock
    AmizadeRepository repository;
    @Mock
    BuscarAmizadePorAmigoEUsuario buscarAmizadePorAmigoEUsuario;
    @InjectMocks
    AceitarAmizadeService aceitarAmizadeService;


    @Test
    public void amizadeDeveSerAceita() throws Exception {
        Amizade amizade = new Amizade();
        amizade.setAceitado(false);

        UserPrincipal usuario = new UserPrincipal(1L, null, null,
                null, null, true, null);
        usuario.setId(1L);
        when(buscarAmizadePorAmigoEUsuario.buscar(anyLong(), anyLong())).thenReturn(amizade);

        aceitarAmizadeService.aceitar(usuario, 2L);

        Assert.assertTrue(amizade.isAceitado());
    }
}
