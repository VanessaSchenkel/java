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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarUsuarioPorNomeOuEmailServiceTest {
    @Mock
    UsuarioRepository repository;
    @InjectMocks
    BuscarUsuarioPorNomeOuEmailService buscarUsuarioPorNomeOuEmailService;


    @Test
    public void deveBuscarUsuarioPorNomeOuEmail() {
        List<Usuario> lista = new ArrayList<>();

        when(repository.findNomeUsuario(anyString())).thenReturn(lista);

        List<Usuario> resultado = buscarUsuarioPorNomeOuEmailService.buscar("Vanessa");
        Assert.assertEquals(lista, resultado);
    }
}