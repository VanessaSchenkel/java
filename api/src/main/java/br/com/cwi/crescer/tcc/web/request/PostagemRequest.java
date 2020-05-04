package br.com.cwi.crescer.tcc.web.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostagemRequest {

    @NotEmpty
    private String texto;

    private String foto;

    @NotNull
    private boolean privado;
}
