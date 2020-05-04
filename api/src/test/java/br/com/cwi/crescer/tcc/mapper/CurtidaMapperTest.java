package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CurtidaMapperTest {

    @Test
    public void deveRetornarCurtida() throws Exception {
        Curtida resultado = CurtidaMapper.transformar(new Usuario(), new Postagem());
        Assert.assertEquals(new Curtida(), resultado);
    }
}