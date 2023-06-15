package com.restaurante.remy.factory;

import com.restaurante.remy.dto.UsuarioDTO;
import com.restaurante.remy.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockFactory {

    public static UsuarioEntity getUsuario(){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1212);
        usuarioEntity.setNombre("pepito");
        usuarioEntity.setApellido1("perez");
        usuarioEntity.setTelefono("31052203000");
        usuarioEntity.setEmail("jdarcila@sura.com.co");
        usuarioEntity.setClave("clave");
        usuarioEntity.setNick("sura");
        usuarioEntity.setTipo("gerente xD");
        usuarioEntity.setUsuarioCrecion("pepito");
        usuarioEntity.setActivo("S");
        return usuarioEntity;
    }

    public static UsuarioEntity getUsuario2(){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1214);
        usuarioEntity.setNombre("pepi");
        usuarioEntity.setApellido1("per");
        usuarioEntity.setTelefono("31052203000");
        usuarioEntity.setEmail("jdarcila@sura.com.co");
        usuarioEntity.setClave("clave");
        usuarioEntity.setNick("sura");
        usuarioEntity.setTipo("gerente xD");
        usuarioEntity.setActivo("S");
        return usuarioEntity;
    }

    public static List<UsuarioEntity> getListUsuario(){
        List<UsuarioEntity> usuarioEntityList = new ArrayList<>();
        usuarioEntityList.add(getUsuario());
        usuarioEntityList.add(getUsuario2());
        return usuarioEntityList;
    }
    public static UsuarioDTO  getUsuarioDTO(){
        return UsuarioDTO.builder()
                .activo("S")
                .tipo("gerente xD")
                .nick("sura")
                .id(1212)
                .clave("clave")
                .email("jdarcila@sura.com.co")
                .nombre("pepi")
                .apellido1("per")
                .telefono("31052203000")
                .build();
    }


    public static UsuarioDTO  getUsuarioDTO2(){
        return UsuarioDTO.builder()
                .activo("S")
                .tipo("gerente xD")
                .nick("sura")
                .id(1214)
                .clave("clave")
                .email("jdarcila@sura.com.co")
                .nombre("pepita")
                .apellido1("per")
                .telefono("31052203000")
                .build();
    }


}