package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioValidatorTest {
    @Mock
    UsuarioRepository repository;
    @InjectMocks
    UsuarioValidator usuarioValidator;


    @Test(expected = ValidacaoNegocioException.class)
    public void deveDispararExcessaoQuandoTemMesmoPaisDeOrigemEAtual() {
        Usuario usuario = new Usuario();
        usuario.setPaisAtual("Brasil");
        usuario.setPaisOrigem("Brasil");

        usuarioValidator.validar(usuario);
    }
}