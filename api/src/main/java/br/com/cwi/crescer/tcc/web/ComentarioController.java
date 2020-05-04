package br.com.cwi.crescer.tcc.web;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.service.ComentarPostagemService;
import br.com.cwi.crescer.tcc.service.ListarComentariosService;
import br.com.cwi.crescer.tcc.web.request.ComentarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    ComentarPostagemService comentarPostagemService;

    @Autowired
   ListarComentariosService listarComentariosService;

    @PostMapping("/{id-postagem}")
    @ResponseStatus(HttpStatus.CREATED)
    public void comentarPostagem(@PathVariable("id-postagem") Long idPostagem, @RequestBody ComentarioRequest request) {
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        comentarPostagemService.comentar(usuario, idPostagem, request);
    }

    @GetMapping("/{id-postagem}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Comentario> listarComentariosDaPostagem(@PathVariable("id-postagem") Long idPostagem) {

        return listarComentariosService.listar(idPostagem);
    }
}
