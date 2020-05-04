package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.mapper.PostagemMapper;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.web.request.PostagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPostagemService {

    @Autowired
    PostagemRepository respository;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    public Postagem criar(PostagemRequest request, UserPrincipal userPrincipal){
        Usuario usuario = buscarUsuarioPorIDService.buscarPorId(userPrincipal.getId());

        Postagem postagem = PostagemMapper.transformar(request, usuario);

        return respository.save(postagem);
    }
}
