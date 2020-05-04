package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Curtida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurtidaRepository extends CrudRepository<Curtida, Long> {

    @Query("SELECT c FROM Curtida c WHERE c.postagem.id = ?1")
    Optional<Curtida> findByPostagemUsuarioCurtidor(Long idPostagem, Long idUsuario);
}

