package com.restaurante.remy.mapping;

import com.restaurante.remy.dto.UsuarioDTO;
import com.restaurante.remy.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapping {

  public   UsuarioEntity usuarioEntityByDTO (UsuarioDTO usuarioDTO){
        return UsuarioEntity.builder()
                            .idUsuario(usuarioDTO.getId())
                            .nombre(usuarioDTO.getNombre())
                            .nick(usuarioDTO.getNick())
                            .clave(usuarioDTO.getClave())
                            .tipo(usuarioDTO.getTipo())
                            .email(usuarioDTO.getEmail())
                            .apellido1(usuarioDTO.getApellido1())
                            .apellido2(usuarioDTO.getApellido2())
                            .telefono(usuarioDTO.getTelefono())
                            .activo(usuarioDTO.getActivo())
                            .build();
    }

    public UsuarioDTO usuarioDTO (UsuarioEntity usuarioEntity){
        return UsuarioDTO.builder()
                            .id(usuarioEntity.getIdUsuario())
                            .apellido1(usuarioEntity.getApellido1())
                            .apellido2(usuarioEntity.getApellido2())
                            .clave(usuarioEntity.getClave())
                            .nick(usuarioEntity.getNick())
                            .email(usuarioEntity.getEmail())
                            .nombre(usuarioEntity.getNombre())
                            .telefono(usuarioEntity.getTelefono())
                            .tipo(usuarioEntity.getTipo())
                            .activo(usuarioEntity.getActivo())
                            .build();
    }

    public List<UsuarioDTO> usuarioDTOList(List<UsuarioEntity> usuarioEntityList){
      List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        usuarioEntityList.forEach(usuarioEntity -> {
          UsuarioDTO usuarioDTO = usuarioDTO(usuarioEntity);
          usuarioDTOList.add(usuarioDTO);
        });
        return usuarioDTOList;
    }
}
