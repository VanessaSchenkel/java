package br.com.cwi.crescer.tcc.web.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String senha;
}
