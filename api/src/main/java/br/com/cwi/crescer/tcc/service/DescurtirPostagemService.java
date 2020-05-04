package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import br.com.cwi.crescer.tcc.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescurtirPostagemService {

    @Autowired
    CurtidaRepository repository;

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    BuscarPostagemPorIDService buscarPostagemPorIDService;

    @Autowired
    BuscarCurtidaPorPostagemIDEUsuarioIDService buscarCurtidaPorPostagemIDEUsuarioIDService;

    public void descurtir(Long idPostagem, Long idUsuario) {
        Postagem postagem = buscarPostagemPorIDService.buscarPorId(idPostagem);
        Curtida curtida = buscarCurtidaPorPostagemIDEUsuarioIDService.buscar(idPostagem, idUsuario);

        postagem.setNumeroCurtidas(postagem.getNumeroCurtidas()-1);
        postagemRepository.save(postagem);

        repository.deleteById(curtida.getId());
    }

}
