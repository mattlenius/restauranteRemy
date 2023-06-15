package com.restaurante.remy.dataprovider;

import com.restaurante.remy.dataprovider.mysql.UsuarioDataProvider;
import com.restaurante.remy.entity.UsuarioEntity;
import com.restaurante.remy.factory.MockFactory;
import com.restaurante.remy.repository.IUsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDataProviderTest {
    @InjectMocks
    private UsuarioDataProvider usuarioDataProvider;

    @Mock
    private IUsuarioRepository iUsuarioRepository;

    @Test
    public void insertarUsuario(){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre("pepito");
        usuarioEntity.setApellido1("perez");
        usuarioEntity.setTelefono("31052203000");
        usuarioEntity.setEmail("jdarcila@sura.com.co");
        usuarioEntity.setClave("clave");
        usuarioEntity.setNick("sura");
        usuarioEntity.setTipo("gerente xD");
        usuarioEntity.setUsuarioCrecion("pepito");
        usuarioDataProvider.saveUsuario(usuarioEntity);
        verify(iUsuarioRepository).saveAndFlush(usuarioEntity);
    }

    @Test
    public void actualizarUsuario(){
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
        usuarioDataProvider.updateUsuario(usuarioEntity);
        verify(iUsuarioRepository).saveAndFlush(usuarioEntity);
    }

    @Test
    public void buscarUsuario() {
        Optional<UsuarioEntity> usuarioEntity = Optional.of(MockFactory.getUsuario());
        Mockito.when(iUsuarioRepository.findById(anyInt())).thenReturn(usuarioEntity);
        UsuarioEntity result = usuarioDataProvider.finIdUsuario(1212);
        assertEquals(usuarioEntity.get(),result);
    }

    @Test
    public void EliminarUsuario(){
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
        usuarioEntity.setActivo("N");
        usuarioDataProvider.deleteId(usuarioEntity);
        verify(iUsuarioRepository).save(usuarioEntity);
    }

    @Test
    public void BuscarTodos(){
        List<UsuarioEntity> usuarioEntityList = MockFactory.getListUsuario();
        Mockito.when(iUsuarioRepository.findAll()).thenReturn(usuarioEntityList);
        List<UsuarioEntity> result = usuarioDataProvider.findAll();
        assertEquals(usuarioEntityList,result);
    }

    @Test
    public void buscarNombre(){
        UsuarioEntity usuarioEntity = MockFactory.getUsuario();
        Mockito.when(iUsuarioRepository.findByNombre("pepito")).thenReturn(usuarioEntity);
        UsuarioEntity result  = usuarioDataProvider.findUsuarioNombre("pepito");
        assertEquals(usuarioEntity,result);
    }




}
