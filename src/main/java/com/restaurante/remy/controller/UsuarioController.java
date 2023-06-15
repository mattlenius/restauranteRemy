package com.restaurante.remy.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.remy.dto.UsuarioDTO;
import com.restaurante.remy.service.IUsuaarioService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remy")
@CrossOrigin(origins = "*")
@Log4j2
@AllArgsConstructor
public class UsuarioController {

    private final IUsuaarioService usuaarioService;

    ObjectMapper objectMapper;


    @ApiResponses(value={
            @ApiResponse(code = 200,message = "Ok. se guardo correctamente",response = UsuarioDTO.class),
            @ApiResponse(code = 400,message = "no llenaste los datos correctamente",response = String.class)
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioResponder= usuaarioService.crearUsuario(usuarioDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body("se registraron los siguientes datos: \n " + objectMapper.writeValueAsString(usuarioResponder));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
