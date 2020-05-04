package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.web.request.ComentarioRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComentarioMapperTest {

    @Test
    public void deveRetornarComentario() throws Exception {
        Comentario resultado = ComentarioMapper.transformar(new Usuario(), new Postagem(), new ComentarioRequest());
        Assert.assertEquals(new Comentario(), resultado);
    }
}