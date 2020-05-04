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
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorid")
    @SequenceGenerator(name = "geradorid", sequenceName = "COMENTARIO_ID_COMENTARIO_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Postagem postagem;

    @NotEmpty
    @Column(nullable = false)
    private String texto;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


}
