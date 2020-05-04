package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AmizadeMapperTest {

    @Test
    public void deveRetornarAmizade() throws Exception {
        Amizade resultado = AmizadeMapper.transformar(new Usuario(), new Usuario());
        Assert.assertEquals(new Amizade(), resultado);
    }
}