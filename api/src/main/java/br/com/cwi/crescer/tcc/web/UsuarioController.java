package br.com.cwi.crescer.tcc.web;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.service.BuscarUsuarioPorNomeOuEmailService;
import br.com.cwi.crescer.tcc.service.CadastrarUsuarioService;
import br.com.cwi.crescer.tcc.service.EditarUsuarioService;
import br.com.cwi.crescer.tcc.service.MostrarInformacoesUsuarioService;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;
import br.com.cwi.crescer.tcc.web.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    EditarUsuarioService editarUsuarioService;

    @Autowired
    MostrarInformacoesUsuarioService mostrarInformacoesUsuarioService;

    @Autowired
    BuscarUsuarioPorNomeOuEmailService buscarUsuarioPorNomeOuEmailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody UsuarioRequest request) {
        return cadastrarUsuarioService.cadastrar(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Usuario editarInformacoes(@RequestBody UsuarioRequest request) {
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return editarUsuarioService.editar(usuario, request);
    }

    @GetMapping("/{id-usuario}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse mostrarUsuario(@PathVariable("id-usuario") Long idUsuario){
        return mostrarInformacoesUsuarioService.mostrar(idUsuario);
    }

    @GetMapping("/minhas-informacoes")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse mostrarUsuarioLogado(){
        UserPrincipal usuario = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return mostrarInformacoesUsuarioService.mostrar(usuario.getId());
    }

    @GetMapping("/buscar/{nome-ou-email}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscarUsuario(@PathVariable("nome-ou-email") String nomeOuEmail){
        return buscarUsuarioPorNomeOuEmailService.buscar(nomeOuEmail);
    }
}
