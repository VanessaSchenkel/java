package br.com.cwi.crescer.tcc.web;

import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.service.CurtirPostagemService;
import br.com.cwi.crescer.tcc.service.DescurtirPostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired
    CurtirPostagemService curtirPostagemService;

    @Autowired
    DescurtirPostagemService descurtirPostagemService;

    @PostMapping("/{id-postagem}")
    @ResponseStatus(HttpStatus.CREATED)
    public void curtirPostagem(@PathVariable("id-postagem") Long idPostagem) {
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        curtirPostagemService.curtir(usuario, idPostagem);
    }

    @DeleteMapping ("/{id-postagem}")
    @ResponseStatus(HttpStatus.OK)
    public void descurtirPostagem(@PathVariable("id-postagem") Long idPostagem) {
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        descurtirPostagemService.descurtir(idPostagem, usuario.getId());
    }
}
