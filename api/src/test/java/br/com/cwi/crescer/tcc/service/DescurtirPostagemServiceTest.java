package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DescurtirPostagemServiceTest {
    @Mock
    CurtidaRepository repository;
    @Mock
    PostagemRepository postagemRepository;
    @Mock
    BuscarPostagemPorIDService buscarPostagemPorIDService;
    @Mock
    BuscarCurtidaPorPostagemIDEUsuarioIDService buscarCurtidaPorPostagemIDEUsuarioIDService;
    @InjectMocks
    DescurtirPostagemService descurtirPostagemService;

    @Test
    public void deveDescurtirPostagem() throws Exception {
        when(buscarPostagemPorIDService.buscarPorId(anyLong())).thenReturn(new Postagem());
        when(buscarCurtidaPorPostagemIDEUsuarioIDService.buscar(anyLong(), anyLong())).thenReturn(new Curtida());

        descurtirPostagemService.descurtir(1L, 1L);
    }
}
