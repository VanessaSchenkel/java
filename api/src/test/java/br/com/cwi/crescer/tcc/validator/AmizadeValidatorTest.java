package br.com.cwi.crescer.tcc.validator;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.exception.ValidacaoAplicacaoException;
import org.junit.Test;

public class AmizadeValidatorTest {
    AmizadeValidator amizadeValidator = new AmizadeValidator();

    @Test(expected = ValidacaoAplicacaoException.class)
    public void deveDispararExcessaoQuandoUsuarioSolicitaAmizadePraEleMemsmo() {
        Amizade amizade = new Amizade();
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        amizade.setUsuarioSolicitado(usuario);
        amizade.setUsuarioSolicitante(usuario);

        amizadeValidator.validar(amizade);
    }
}
