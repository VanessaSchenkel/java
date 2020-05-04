package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.validator.JaPossuiCadastroValidator;
import br.com.cwi.crescer.tcc.validator.UsuarioValidator;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUsuarioServiceTest {
    @Mock
    UsuarioRepository repository;
    @Mock
    UsuarioValidator validator;
    @Mock
    JaPossuiCadastroValidator jaPossuiCadastroValidator;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    CadastrarUsuarioService cadastrarUsuarioService;

    @Test
    public void deveCadastrarNovoUsuario() {
        UsuarioRequest request = new UsuarioRequest();
        Usuario usuarioMapeado = new Usuario();
        Usuario usuarioSalvo = new Usuario();

        when(repository.save(usuarioMapeado)).thenReturn(usuarioSalvo);

        Usuario usuarioResultado = cadastrarUsuarioService.cadastrar(request);

        Assert.assertSame(usuarioResultado, usuarioSalvo);

    }
}

