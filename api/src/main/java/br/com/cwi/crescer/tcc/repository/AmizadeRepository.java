package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Amizade;
import br.com.cwi.crescer.tcc.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AmizadeRepository extends CrudRepository<Amizade, Long> {

    Optional<Amizade> findById(Long id);

    @Query("SELECT u FROM Usuario u " +
            "JOIN br.com.cwi.crescer.tcc.domain.Amizade a " +
            "ON (a.usuarioSolicitante.id = u.id AND a.usuarioSolicitado.id = ?1) " +
            "OR (a.usuarioSolicitante.id = ?1 AND a.usuarioSolicitado.id = u.id) " +
            "WHERE a.aceitado = true AND (a.usuarioSolicitante.id != ?1 OR a.usuarioSolicitado.id != ?1)")
    Page<Usuario> listarAmigos(Long id, Pageable pageable);

    @Query("SELECT u FROM Usuario u " +
            "JOIN br.com.cwi.crescer.tcc.domain.Amizade a " +
            "ON (a.usuarioSolicitado.id = ?1 AND a.usuarioSolicitante.id = u.id) " +
            "WHERE a.aceitado = false AND (a.usuarioSolicitante.id != ?1 OR a.usuarioSolicitado.id != ?1)")
    List<Usuario> listarSolicitacoesDeAmizade(Long id);

    @Query("SELECT a FROM Amizade a WHERE (a.usuarioSolicitante.id = ?1 AND a.usuarioSolicitado.id = a.id) AND a.aceitado = false")
    Amizade findByUsuarioSolicitadoESolicitante(Long idAmigo, Long id);

    @Query("SELECT a FROM Amizade a WHERE (a.usuarioSolicitante.id = ?1 AND a.usuarioSolicitado.id = a.id)")
    Amizade findParaDeletar(Long idAmigo, Long id);

    boolean existsByUsuarioSolicitanteIdAndUsuarioSolicitadoId(Long idSolicitando, Long idSolicitado);

}
