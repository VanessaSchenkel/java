package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.ComentarioRepository;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.web.request.ComentarioRequest;
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
public class ComentarPostagemServiceTest {
    @Mock
    ComentarioRepository repository;
    @Mock
    PostagemRepository postagemRepository;
    @Mock
    BuscarPostagemPorIDService buscarPostagemPorIDService;
    @Mock
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;
    @InjectMocks
    ComentarPostagemService comentarPostagemService;

    @Test
    public void usuarioDevePoderComentarEmPostagem() {
        Postagem postagem = new Postagem();

        Usuario usuario = new Usuario();
        UserPrincipal user = new UserPrincipal(1L, null, null, null, null, null, null);

        ComentarioRequest request = new ComentarioRequest();
        Comentario comentarioMapeado = new Comentario();
        Comentario comentarioSalvo = new Comentario();

        when(buscarPostagemPorIDService.buscarPorId(anyLong())).thenReturn(postagem);
        when(buscarUsuarioPorIDService.buscarPorId(anyLong())).thenReturn(usuario);
        when(repository.save(comentarioMapeado)).thenReturn(comentarioSalvo);

        comentarPostagemService.comentar(user, 1L, request);

    }
}