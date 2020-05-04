package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarPostagemPorIDServiceTest {
    @Mock
    PostagemRepository repository;
    @InjectMocks
    BuscarPostagemPorIDService buscarPostagemPorIDService;

    @Test
    public void deveBuscarPostagemPorId() {
        Postagem postagem = new Postagem();

        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(postagem));

        Postagem resultado = buscarPostagemPorIDService.buscarPorId(1L);
        Assert.assertEquals(postagem, resultado);
    }
}

