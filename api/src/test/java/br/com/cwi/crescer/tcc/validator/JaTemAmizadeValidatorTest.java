package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import br.com.cwi.crescer.tcc.service.VerificaSeJaTemAmizadeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JaTemAmizadeValidatorTest {
    @Mock
    VerificaSeJaTemAmizadeService verificaSeJaTemAmizadeService;
    @InjectMocks
    JaTemAmizadeValidator jaTemAmizadeValidator;

    @Test(expected = ValidacaoAplicacaoException.class)
    public void deveDispararExcessaoQuandoJaPossuiAmizade() {
        when(verificaSeJaTemAmizadeService.amizadeJaExiste(anyLong(), anyLong())).thenReturn(true);

        jaTemAmizadeValidator.validar(1L, 5L);
    }
}