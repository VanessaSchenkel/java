package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.AmizadeRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
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
public class ListarSolicitacoesAmizadeServiceTest {
    @Mock
    AmizadeRepository repository;
    @Mock
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;
    @Mock
    BuscarListaSolicitacoesAmizadeService buscarListaSolicitacoesAmizadeService;
    @InjectMocks
    ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;


    @Test
    public void deveListarSolicitacoesDeAmizade() {
        List<Usuario> lista = new ArrayList<>();

        when(buscarListaSolicitacoesAmizadeService.buscarListaPorIdUsuario(anyLong())).thenReturn(lista);

        List<Usuario> resultado = listarSolicitacoesAmizadeService.listar(new UserPrincipal(Long.valueOf(1), null, null, null, null, null, null));
        Assert.assertEquals(lista, resultado);
    }
}