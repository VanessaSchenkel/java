package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarPostagensDoUsuarioServiceTest {
    @Mock
    PostagemRepository repository;
    
    @InjectMocks
    BuscarPostagensDoUsuarioService buscarPostagensDoUsuarioService;

    @Test
    public void deveBuscarPostagemPeloUsuarioID() {
        List<Postagem> lista = new ArrayList<>();
        Page<Postagem> postagens = new PageImpl<>(lista);

        when(repository.findByUsuarioId(anyLong(), any())).thenReturn(postagens);

        Page<Postagem> resultado = buscarPostagensDoUsuarioService.buscar(Long.valueOf(1), null);
        Assert.assertEquals(postagens, resultado);
    }
}