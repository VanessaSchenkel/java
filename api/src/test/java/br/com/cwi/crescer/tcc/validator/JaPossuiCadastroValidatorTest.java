package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class JaPossuiCadastroValidatorTest {
    @Mock
    UsuarioRepository repository;
    @InjectMocks
    JaPossuiCadastroValidator jaPossuiCadastroValidator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveDispararExcessaoQuandoJaPossuiEmailCadastrado()  {
        when(repository.existsByEmail(anyString())).thenReturn(true);

        jaPossuiCadastroValidator.validar(new Usuario());
    }
}