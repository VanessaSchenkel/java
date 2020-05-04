package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.ComentarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarComentarioPorPostagemIDServiceTest {
    @Mock
    ComentarioRepository repository;
    @InjectMocks
    BuscarComentarioPorPostagemIDService buscarComentarioPorPostagemIDService;

    @Test
    public void deveBuscarComentariosPeloIdDaPostagem() throws Exception {
        List<Comentario> comentarios = new ArrayList<>();

        Postagem postagem = new Postagem();
        postagem.setId(1L);

        when(repository.findByPostagemId(postagem.getId())).thenReturn(comentarios);

        List<Comentario> resultado = buscarComentarioPorPostagemIDService.buscarPorPostagemId(postagem.getId());
        Assert.assertEquals(comentarios, resultado);
    }


}
