package br.com.cwi.crescer.tcc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorid")
    @SequenceGenerator(name = "geradorid", sequenceName = "AMIZADE_ID_AMIZADE_SEQ", allocationSize = 1)
    private Long id;

    @NotNull
    private boolean aceitado;

    @NotNull
    private LocalDate dataAmizade;

    @ManyToOne
    @JoinColumn(name = "id_solicitante")
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "id_solicitado")
    private Usuario usuarioSolicitado;

}
