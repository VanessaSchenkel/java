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
public class BuscarAmizadePorIdServiceTest {
    @Mock
    AmizadeRepository repository;

    @InjectMocks
    BuscarAmizadePorIdService buscarAmizadePorIdService;

    @Test
    public void deveBuscarAmizadeNoRepositorio() throws Exception {
        Amizade amizade = new Amizade();
        amizade.setId(1L);
        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(amizade));

        Amizade resultado = buscarAmizadePorIdService.buscarPorId(1L);
        Assert.assertEquals(amizade, resultado);

    }
}
