package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.web.response.UsuarioResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MostrarInformacoesUsuarioServiceTest {
    @Mock
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;
    @InjectMocks
    MostrarInformacoesUsuarioService mostrarInformacoesUsuarioService;

    @Test
    public void deveMostrarInformacoesDoUsuario(){
        when(buscarUsuarioPorIDService.buscarPorId(anyLong())).thenReturn(new Usuario());

        UsuarioResponse resultado = mostrarInformacoesUsuarioService.mostrar(1L);
        Assert.assertEquals(new UsuarioResponse(), resultado);
    }
}