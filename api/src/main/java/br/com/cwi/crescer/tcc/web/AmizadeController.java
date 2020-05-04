package br.com.cwi.crescer.tcc.web;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private SolicitarAmizadeService solicitarAmizadeService;

    @Autowired
    private ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;

    @Autowired
    private ListarAmizadesAceitasService listarAmizadesAceitasService;

    @Autowired
    private AceitarAmizadeService aceitarAmizadeService;

    @Autowired
    private DeletarAmizadeService deletarAmizadeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<Usuario> listarAmigos(@PageableDefault(size = 5) Pageable pageable){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return listarAmizadesAceitasService.listar(usuario.getId(), pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id-amigo}")
    public Amizade solicitarAmizade(@PathVariable("id-amigo") Long idAmigo){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return solicitarAmizadeService.solicitar(idAmigo, usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/solicitacoes")
    public List<Usuario> listarSolicitacoesDeAmizade(){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return listarSolicitacoesAmizadeService.listar(usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/solicitacoes/{id-amigo}")
    public void aceitarAmizade(@PathVariable("id-amigo") Long idAmigo){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        aceitarAmizadeService.aceitar(usuario, idAmigo);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-amigo}")
    public void deletarAmizade(@PathVariable("id-amigo") Long idAmigo){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        deletarAmizadeService.deletar(idAmigo,usuario);
    }
}
