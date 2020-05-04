package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.mapper.ComentarioMapper;
import br.com.cwi.crescer.tcc.repository.ComentarioRepository;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.web.request.ComentarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarPostagemService {

    @Autowired
    ComentarioRepository repository;

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    BuscarPostagemPorIDService buscarPostagemPorIDService;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    public void comentar(UserPrincipal usuario, Long idPostagem, ComentarioRequest request) {
        Postagem postagem = buscarPostagemPorIDService.buscarPorId(idPostagem);
        Usuario user = buscarUsuarioPorIDService.buscarPorId(usuario.getId());

        Comentario comentario = ComentarioMapper.transformar(user, postagem, request);

        repository.save(comentario);
    }
}
