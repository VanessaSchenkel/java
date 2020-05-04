package br.com.cwi.crescer.tcc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorid")
    @SequenceGenerator(name = "geradorid", sequenceName = "POSTAGEM_ID_POSTAGEM_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotEmpty
    @Column(nullable = false)
    private String texto;

    @NotEmpty
    @Column(length = 512)
    private String foto;

    @NotNull
    private boolean privado;

    private int numeroCurtidas;

}
