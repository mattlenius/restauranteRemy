package com.restaurante.remy.dataprovider.mysql;

import com.restaurante.remy.dataprovider.IUsuarioDataProvider;
import com.restaurante.remy.entity.UsuarioEntity;
import com.restaurante.remy.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UsuarioDataProvider implements IUsuarioDataProvider {

    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public UsuarioEntity saveUsuario(UsuarioEntity entity) {
        UsuarioEntity usuarioEntity = iUsuarioRepository.saveAndFlush(entity);
        return usuarioEntity;
    }

    @Override
    public UsuarioEntity updateUsuario(UsuarioEntity entity) {
        UsuarioEntity usuarioEntity = iUsuarioRepository.saveAndFlush(entity);
        return usuarioEntity;
    }

    @Override
    public UsuarioEntity finIdUsuario(Integer idUsuario) {
        Optional<UsuarioEntity> usuarioEntity = iUsuarioRepository.findById(idUsuario);
        return usuarioEntity.get();
    }

    @Override
    public void deleteId(UsuarioEntity entity) {
        iUsuarioRepository.save(entity);
    }

    @Override
    public List<UsuarioEntity> findAll() {
        List<UsuarioEntity> usuarioEntityList = iUsuarioRepository.findAll();
        return usuarioEntityList;
    }

    @Override
    public UsuarioEntity findUsuarioNombre(String nombre) {
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByNombre(nombre);
        return usuarioEntity;
    }
}
