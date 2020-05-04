package br.com.cwi.crescer.tcc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorid")
    @SequenceGenerator(name = "geradorid", sequenceName = "USUARIO_ID_USUARIO_SEQ", allocationSize = 1)
    private Long id;

    @NotEmpty
    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "apelido", length = 50)
    private String apelido;

    @Email
    @NotEmpty
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "senha", nullable = false, length = 128)
    private String senha;

    private boolean ativo = true;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(name = "imagem_perfil", length = 512)
    private String imagemPerfil;

    @NotEmpty
    @Column(name = "pais_origem", nullable = false, length = 60)
    private String paisOrigem;

    @NotEmpty
    @Column(name = "pais_atual", nullable = false, length = 60)
    private String paisAtual;

    public Perfil getPerfil(){
        return Perfil.USUARIO;
    }
}
