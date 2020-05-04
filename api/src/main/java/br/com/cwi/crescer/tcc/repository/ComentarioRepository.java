package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Comentario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

    Optional<Comentario> findById(Long id);

    List<Comentario> findByPostagemId(Long idPostagem);
}

