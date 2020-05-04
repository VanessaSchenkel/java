package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findAllByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long id);

    boolean existsByEmail(String email);

    @Query("Select c from Usuario c where c.nomeCompleto LIKE  %?1% or c.email LIKE  %?1% ")
    List<Usuario> findNomeUsuario(String nomeOuEmail);



}
