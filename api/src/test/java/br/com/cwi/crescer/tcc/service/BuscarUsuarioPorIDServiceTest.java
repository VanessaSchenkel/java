package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
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
public class BuscarUsuarioPorIDServiceTest {
    @Mock
    UsuarioRepository repository;

    @InjectMocks
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    @Test
    public void deveBuscarUsuarioPorID() {
        Usuario usuario = new Usuario();

        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(usuario));

        Usuario resultado = buscarUsuarioPorIDService.buscarPorId(1L);
        Assert.assertEquals(usuario, resultado);
    }
}
