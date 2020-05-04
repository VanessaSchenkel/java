package br.com.cwi.crescer.tcc.web.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UsuarioRequest {

    @NotEmpty
    private String nomeCompleto;

    private String apelido;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String senha;

    private boolean ativo = true;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    private String imagemPerfil;

    @NotEmpty
    private String paisOrigem;

    @NotEmpty
    private String paisAtual;

}
