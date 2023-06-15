package com.restaurante.remy.service.impl;

import com.restaurante.remy.dataprovider.IUsuarioDataProvider;
import com.restaurante.remy.dto.UsuarioDTO;
import com.restaurante.remy.entity.UsuarioEntity;
import com.restaurante.remy.mapping.UsuarioMapping;
import com.restaurante.remy.service.IUsuaarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class UsuarioService implements IUsuaarioService {

    private final IUsuarioDataProvider usuarioDataProvider;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = usuarioDataProvider.findUsuarioNombre(usuarioDTO.getNombre());
        if (Objects.isNull(usuario)){
            usuario = usuarioDataProvider.saveUsuario(new UsuarioMapping().usuarioEntityByDTO(usuarioDTO));

            if (Objects.nonNull(usuario)){
                return new UsuarioMapping().usuarioDTO(usuario);
            }
        }
        return null;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = usuarioDataProvider.finIdUsuario(usuarioDTO.getId());
        if(Objects.nonNull(usuario)){
            usuario = usuarioDataProvider.updateUsuario(new UsuarioMapping().usuarioEntityByDTO(usuarioDTO));
            if(Objects.nonNull(usuario)){
                return  new UsuarioMapping().usuarioDTO(usuario);
            }
        }
        return null;
    }

    @Override
    public UsuarioDTO buscarUsuarioPorID(Integer idUsuario) {
        UsuarioEntity usuario = usuarioDataProvider.finIdUsuario(idUsuario);
        if (Objects.nonNull(usuario)){
            return  new UsuarioMapping().usuarioDTO(usuario);
        }
        return null;
    }

    @Override
    public String borrarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = new UsuarioMapping().usuarioEntityByDTO(usuarioDTO);
        usuario = usuarioDataProvider.finIdUsuario(usuario.getIdUsuario());
        if (Objects.nonNull(usuario)){
            usuarioDataProvider.deleteId(usuario);
            return "Borro Exitosamente";
        }
        return  "no se borro exitosamente";

    }

    public List<UsuarioDTO> buscarTodoUsuario(){
        List<UsuarioEntity> usuarioEntity = usuarioDataProvider.findAll();
        if (Objects.nonNull(usuarioEntity)){
            return new UsuarioMapping().usuarioDTOList(usuarioEntity);
        }
        return null;
    }
}
