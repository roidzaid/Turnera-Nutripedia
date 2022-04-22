package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.UsuarioEntity;
import com.ItRoid.Turnera.models.UsuarioModel;
import com.ItRoid.Turnera.repositories.UsuarioRepository;
import com.ItRoid.Turnera.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel) throws Exception {

        UsuarioEntity u = this.usuarioRepository.buscarUsuarioxIdProfesional(usuarioModel.getIdProfesional());

        if(u == null) {

            UsuarioEntity usuarioEntity = new UsuarioEntity(
                    usuarioModel.getUsuario(),
                    usuarioModel.getContraseña(),
                    usuarioModel.getIdProfesional()
            );

            this.usuarioRepository.save(usuarioEntity);

            return usuarioModel;
        }else
            throw new Exception("Ya existe usuario para el profesional: " + usuarioModel.getIdProfesional());

    }

    @Override
    public UsuarioModel actualizarContraseña(Long idProfecional, UsuarioModel usuarioModel) {
        return null;
    }

    @Override
    public UsuarioModel buscarUsuario(String usuario, String contraseña) throws Exception {

        UsuarioEntity usuarioEntity = this.usuarioRepository.buscarUsuario(usuario, contraseña);

        if (usuarioEntity != null) {

            UsuarioModel usuarioModel = new UsuarioModel(
                    usuarioEntity.getUsuario(),
                    usuarioEntity.getContraseña(),
                    usuarioEntity.getIdProfesional()
            );

            return usuarioModel;
        }else{
            throw new Exception("No existe usuario y/o contraseña");
        }

    }
}
