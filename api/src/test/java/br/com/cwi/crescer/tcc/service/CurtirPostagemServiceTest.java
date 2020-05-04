package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CurtirPostagemServiceTest {
    @Mock
    CurtidaRepository repository;
    @Mock
    PostagemRepository postagemRepository;
    @Mock
    BuscarPostagemPorIDService buscarPostagemPorIDService;
    @Mock
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;
    @InjectMocks
    CurtirPostagemService curtirPostagemService;

    @Test
    public void deveCriarCurtida() {
        UserPrincipal userPrincipal = new UserPrincipal(1L, null, null, null, null, null, null);
        Postagem postagem = new Postagem();
        Usuario usuario = new Usuario();
        Curtida curtidaMapeado = new Curtida();
        Curtida curtidaSalvo = new Curtida();

        when(buscarPostagemPorIDService.buscarPorId(anyLong())).thenReturn(postagem);
        when(buscarUsuarioPorIDService.buscarPorId(anyLong())).thenReturn(usuario);
        when(repository.save(curtidaMapeado)).thenReturn(curtidaSalvo);

        curtirPostagemService.curtir(userPrincipal, 1L);

        Mockito.verify(repository).save(curtidaMapeado);

    }
}