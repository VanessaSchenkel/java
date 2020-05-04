package br.com.cwi.crescer.tcc.web;

import br.com.cwi.crescer.tcc.domain.Postagem;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.service.*;
import br.com.cwi.crescer.tcc.web.request.PostagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private CriarPostagemService criarPostagemService;

    @Autowired
    private ListarPostagensDoUsuarioService listarPostagensDoUsuarioService;

    @Autowired
    private ListarTodasPostagensDoUsuarioEAmigosService listarTodasPostagensService;

    @Autowired
    private ListarPostagensDoContatoService listarPostagensDoContatoService;

    @Autowired
    private EditarPrivacidadePostagemService editarPrivacidadePostagemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Postagem criar(@RequestBody PostagemRequest request) {
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return criarPostagemService.criar(request, usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/minhas-postagens")
    public Page<Postagem> listarMinhasPostagens(@PageableDefault(sort = "data",  direction = Sort.Direction.DESC, size = 15) Pageable pageable){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return listarPostagensDoUsuarioService.listar(usuario.getId(), pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("outros/{id-amigo}")
    public Page<Postagem> listarPostagensUsuario(@PageableDefault(sort = "data", direction = Sort.Direction.DESC, size = 15) Pageable pageable, @PathVariable("id-amigo") Long idAmigo){
        return listarPostagensDoContatoService.listar(idAmigo, pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todas")
    public Page<Postagem> listarTodasPostagens(@PageableDefault(sort = "data", direction = Sort.Direction.DESC, size = 15) Pageable pageable){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return listarTodasPostagensService.buscar(usuario.getId(), pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/mudar-privacidade/{id-post}")
    public void editarPrivacidade(@PathVariable("id-post") Long idPost){
         editarPrivacidadePostagemService.editar(idPost);
    }
}
