package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.web.request.PostagemRequest;
import org.junit.Assert;
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
public class CriarPostagemServiceTest {
    @Mock
    PostagemRepository respository;
    @Mock
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;
    @InjectMocks
    CriarPostagemService criarPostagemService;

    @Test
    public void deveCriarPostagem() {
       UserPrincipal userPrincipal = new UserPrincipal(1L, null, null, null, null, null, null);
       PostagemRequest request = new PostagemRequest();
       Postagem postagemMapeada = new Postagem();
       Postagem postagemSalva = new Postagem();

        when(respository.save(postagemMapeada)).thenReturn(postagemSalva);

        Postagem resultado = criarPostagemService.criar(request, userPrincipal);

        Mockito.verify(respository).save(postagemMapeada);

        Assert.assertSame(resultado, postagemSalva);
    }
}