package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarAmizadePorAmigoEUsuarioTest {
    @Mock
    AmizadeRepository repository;
    @InjectMocks
    BuscarAmizadePorAmigoEUsuario buscarAmizadePorAmigoEUsuario;

    @Test
    public void deveBuscarAmizadeQuandoRecebeUsuarioLogadoEAmigo() {
        Amizade amizade = new Amizade();

        when(repository.findByUsuarioSolicitadoESolicitante(anyLong(), anyLong())).thenReturn(amizade);

        Amizade resultado = buscarAmizadePorAmigoEUsuario.buscar(1L, 2L);

        Assert.assertEquals(amizade, resultado);
    }
}
