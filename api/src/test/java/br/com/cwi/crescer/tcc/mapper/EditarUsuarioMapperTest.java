package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class EditarUsuarioMapperTest {

    @Test
    public void deveRetornarUsuario()  {
        UserPrincipal userPrincipal = new UserPrincipal(1L, null, null, null, null, null, null);

        Usuario resultado = EditarUsuarioMapper.editar(
                userPrincipal, new UsuarioRequest(), new Usuario());
        Assert.assertEquals(new Usuario(), resultado);
    }
}