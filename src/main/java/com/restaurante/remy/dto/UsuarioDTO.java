package com.restaurante.remy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@Setter
@Getter
@Builder
@Validated
public class UsuarioDTO {

    @JsonProperty("id_usuario")
    @Valid
    private Integer id;

    @Valid
    private String nombre;

    private String telefono;

    private String apellido1;

    private String apellido2;

    private String email;

    private String nick;

    private String clave;

    private String tipo;
    private String activo;

}
