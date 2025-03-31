package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.UsuarioModel;

public interface UsuarioService<T>{

    UsuarioModel guardarUsuario(UsuarioModel usuarioModel) throws Exception;

    UsuarioModel actualizarContraseña(Long idProfecional, UsuarioModel usuarioModel);

    UsuarioModel buscarUsuario(String usuario, String contraseña) throws Exception;

}
