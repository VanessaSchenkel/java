package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.mapper.CurtidaMapper;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirPostagemService {

    @Autowired
    CurtidaRepository repository;

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    BuscarPostagemPorIDService buscarPostagemPorIDService;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;

    public void curtir(UserPrincipal usuario, Long idPostagem) {
        Postagem postagem = buscarPostagemPorIDService.buscarPorId(idPostagem);
        Usuario user = buscarUsuarioPorIDService.buscarPorId(usuario.getId());

        Curtida curtida = CurtidaMapper.transformar(user, postagem);

        postagem.setNumeroCurtidas(postagem.getNumeroCurtidas()+1);
        postagemRepository.save(postagem);

        repository.save(curtida);
    }

}
