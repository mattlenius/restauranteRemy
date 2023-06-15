package com.restaurante.remy.service;

import com.restaurante.remy.dto.UsuarioDTO;

import java.util.List;

public interface IUsuaarioService {

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO buscarUsuarioPorID(Integer idUsuario);

    String  borrarUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> buscarTodoUsuario();
}
