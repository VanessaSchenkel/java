package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
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
public class ListarComentariosServiceTest {
    @Mock
    BuscarComentarioPorPostagemIDService buscarComentariosService;
    @InjectMocks
    ListarComentariosService listarComentariosService;

    @Test
    public void deveListarCometarios() {
        List<Comentario> lista = new ArrayList<>();

        when(buscarComentariosService.buscarPorPostagemId(anyLong())).thenReturn(lista);

        List<Comentario> resultado = listarComentariosService.listar(Long.valueOf(1));
        Assert.assertEquals(lista, resultado);
    }
}