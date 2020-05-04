package br.com.cwi.crescer.tcc.web;

import javax.validation.Valid;

import br.com.cwi.crescer.tcc.security.AuthenticationService;
import br.com.cwi.crescer.tcc.web.request.LoginRequest;
import br.com.cwi.crescer.tcc.web.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {

        final String token = service.authenticate(request.getEmail(), request.getSenha());

        return new LoginResponse(token);
    }
}
