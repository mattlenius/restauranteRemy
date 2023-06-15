package com.restaurante.remy.servicio;


import com.restaurante.remy.dataprovider.mysql.UsuarioDataProvider;
import com.restaurante.remy.dto.UsuarioDTO;
import com.restaurante.remy.entity.UsuarioEntity;
import com.restaurante.remy.factory.MockFactory;
import com.restaurante.remy.service.impl.UsuarioService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {
    @InjectMocks
    UsuarioService usuarioService;

    @Mock
    UsuarioDataProvider usuarioDataProvider;

    @Test
    public void guardarUsuario(){
        UsuarioDTO  usuarioDTO = MockFactory.getUsuarioDTO();
        Mockito.when(usuarioDataProvider.findUsuarioNombre(anyString())).thenReturn(null);
        Mockito.when(usuarioDataProvider.saveUsuario(any(UsuarioEntity.class))).thenReturn(MockFactory.getUsuario());
        UsuarioDTO result = usuarioService.crearUsuario(usuarioDTO);
        assertEquals(usuarioDTO.getId(),result.getId());
    }

    @Test
    public void actualizarUsuario(){
        UsuarioDTO  usuarioDTO = MockFactory.getUsuarioDTO2();
        Mockito.when(usuarioDataProvider.finIdUsuario(anyInt())).thenReturn(MockFactory.getUsuario());
        Mockito.when(usuarioDataProvider.updateUsuario(any(UsuarioEntity.class))).thenReturn(MockFactory.getUsuario2());
        UsuarioDTO result = usuarioService.actualizarUsuario(usuarioDTO);
        assertEquals(usuarioDTO.getId(),result.getId());
    }

    @Test
    public  void buscarUsuario(){
        UsuarioDTO  usuarioDTO = MockFactory.getUsuarioDTO();
        Mockito.when(usuarioDataProvider.finIdUsuario(anyInt())).thenReturn(MockFactory.getUsuario());
        UsuarioDTO result = usuarioService.buscarUsuarioPorID(anyInt());
        assertEquals(usuarioDTO.getId(),result.getId());
    }

    @Test
    public  void borrarUsuario(){
        UsuarioDTO  usuarioDTO = MockFactory.getUsuarioDTO();
        Mockito.when(usuarioDataProvider.finIdUsuario(anyInt())).thenReturn(MockFactory.getUsuario());
        String result = usuarioService.borrarUsuario(usuarioDTO);
        Assertions.assertNotNull(result);
    }

    @Test
    public void buscarTodoUsuario(){
        Mockito.when(usuarioDataProvider.findAll()).thenReturn(MockFactory.getListUsuario());
        List<UsuarioDTO> result = usuarioService.buscarTodoUsuario();
        Assertions.assertNotNull(result);
    }




}
