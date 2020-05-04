package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
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
public class BuscarListaSolicitacoesAmizadeServiceTest {
    @Mock
    AmizadeRepository repository;
    @InjectMocks
    BuscarListaSolicitacoesAmizadeService buscarListaSolicitacoesAmizadeService;


    @Test
    public void deveBuscarListaDeSolicitacoesDeAmizadePeloIdUsuarioERetornarUsuarios() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        List<Usuario> lista = new ArrayList<>();

        when(repository.listarSolicitacoesDeAmizade(anyLong())).thenReturn(lista);

        List<Usuario> resultado = buscarListaSolicitacoesAmizadeService.buscarListaPorIdUsuario(1L);
        Assert.assertEquals(lista, resultado);
    }
}

