package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarCurtidaPorPostagemIDEUsuarioIDServiceTest {
    @Mock
    CurtidaRepository repository;
    @InjectMocks
    BuscarCurtidaPorPostagemIDEUsuarioIDService buscarCurtidaPorPostagemIDEUsuarioIDService;

    @Test
    public void deveBuscarCurtidaPorIdPostagemEUsuario() throws Exception {
        Curtida curtida = new Curtida();
        when(repository.findByPostagemUsuarioCurtidor(anyLong(), anyLong())).thenReturn(java.util.Optional.of(curtida));

        Curtida resultado = buscarCurtidaPorPostagemIDEUsuarioIDService.buscar(1L, 1L);
        Assert.assertEquals(curtida, resultado);
    }
}

