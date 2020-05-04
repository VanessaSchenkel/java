package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Usuario;
import br.com.cwi.crescer.tcc.mapper.EditarUsuarioMapper;
import br.com.cwi.crescer.tcc.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.UserPrincipal;
import br.com.cwi.crescer.tcc.validator.UsuarioValidator;
import br.com.cwi.crescer.tcc.web.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarUsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioValidator validator;

    @Autowired
    BuscarUsuarioPorIDService buscarUsuarioPorIDService;


    public Usuario editar(UserPrincipal usuario, UsuarioRequest request){
        Usuario usuarioBuscado = buscarUsuarioPorIDService.buscarPorId(usuario.getId());

        Usuario usuarioAtualizado = EditarUsuarioMapper.editar(usuario, request, usuarioBuscado);

        validator.validar(usuarioAtualizado);

        return repository.save(usuarioAtualizado);
    }



}
