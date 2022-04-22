package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.UsuarioModel;

public interface UsuarioService<T>{

    UsuarioModel guardarUsuario(UsuarioModel usuarioModel) throws Exception;

    UsuarioModel actualizarContraseña(Long idProfecional, UsuarioModel usuarioModel);

    UsuarioModel buscarUsuario(String usuario, String contraseña) throws Exception;

}
