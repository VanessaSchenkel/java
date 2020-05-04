package br.com.cwi.crescer.tcc.web.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponse {
    private Long id;

    private String nomeCompleto;

    private String apelido;

    private String email;

    private LocalDate dataNascimento;

    private String imagemPerfil;

    private String paisOrigem;

    private String paisAtual;
}
