package br.com.cwi.crescer.tcc.web.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ComentarioRequest {

    @NotEmpty
    private String texto;
}
