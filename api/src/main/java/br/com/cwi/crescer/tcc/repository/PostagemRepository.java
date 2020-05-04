package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Postagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostagemRepository extends CrudRepository<Postagem, Long> {
    Optional<Postagem> findById(Long id);

    Page<Postagem> findByUsuarioId(Long id, Pageable pageable);

    @Query("SELECT p FROM Postagem p JOIN br.com.cwi.crescer.tcc.domain.Amizade a " +
            "ON (a.usuarioSolicitado.id = p.usuario.id " +
            "OR a.usuarioSolicitante.id = p.usuario.id) " +
            "WHERE (a.usuarioSolicitante.id = ?1 OR a.usuarioSolicitado.id = ?1 ) AND (a.aceitado = TRUE OR p.usuario.id = ?1)")
    Page<Postagem> findAllPostsFromUserAndFriends(Long id,  Pageable page);

}
