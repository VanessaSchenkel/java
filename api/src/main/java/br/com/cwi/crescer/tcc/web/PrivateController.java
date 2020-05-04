package br.com.cwi.crescer.tcc.web;

import javax.annotation.security.RolesAllowed;

import br.com.cwi.crescer.tcc.security.UserPrincipal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/private/controller")
public class PrivateController {

    @GetMapping
    public String getComAutenticacao() {
        return "/private/controller: com restrições";
    }

    @GetMapping("/logado/annotation")
    public UserPrincipal getCurrentUserComAnnotation(@AuthenticationPrincipal UserPrincipal currentUser) {
        return currentUser;
    }

    @GetMapping("/logado/context")
    public UserPrincipal getCurrentUserSemAnnotation() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);

        // pode ser usado em qualquer lugar dentro do contexto do Spring
        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser);

        return currentUser;
    }

    @RolesAllowed({ "ROLE_ADMIN" })
    @GetMapping("/admin")
    public String roleAdmin() {
        return "/private/controller/admin";
    }

    @RolesAllowed({ "ROLE_ADMIN", "ROLE_USUARIO" })
    @GetMapping("/usuario")
    public String roleUsuario() {
        return "/private/controller/usuario";
    }

}
