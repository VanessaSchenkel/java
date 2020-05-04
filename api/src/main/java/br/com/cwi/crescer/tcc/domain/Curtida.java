package br.com.cwi.crescer.tcc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
public class Curtida{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorid")
    @SequenceGenerator(name = "geradorid", sequenceName = "CURTIDA_ID_CURTIDA_SEQ", allocationSize = 1)
    private Long id;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_usuario_curtidor")
    private Usuario usuarioCurtidor;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

}
