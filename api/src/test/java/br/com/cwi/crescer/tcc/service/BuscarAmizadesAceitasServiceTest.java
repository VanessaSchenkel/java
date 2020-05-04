package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarAmizadesAceitasServiceTest {
    @Mock
    AmizadeRepository repository;
    @Mock
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;
    @InjectMocks
    BuscarAmizadesAceitasService buscarAmizadesAceitasService;

    @Test
    public void deveBuscarAmizadesAceitasDoUsuario() throws Exception {
        when(repository.listarAmigos(anyLong(), any())).thenReturn(null);

        Page<Usuario> result = buscarAmizadesAceitasService.buscarListaPorIdUsuario(Long.valueOf(1), null);
        Assert.assertEquals(null, result);
    }
}