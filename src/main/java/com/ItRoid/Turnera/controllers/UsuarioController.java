package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.UsuarioModel;
import com.ItRoid.Turnera.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("usuarios")
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioModel usuarioModel) throws Exception  {

        logger.info("Se guarda usuario para el profesional: " + usuarioModel.getIdProfesional());

        try {

            UsuarioModel usuario = this.usuarioService.guardarUsuario(usuarioModel);

            return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{usuario}/{contraseña}")
    public ResponseEntity<?> budcarUsuario(@PathVariable("usuario") String usuario, @PathVariable("contraseña") String contraseña) throws Exception{

        logger.info("se busca usuario: " + usuario);

        try {

            UsuarioModel usu = this.usuarioService.buscarUsuario(usuario, contraseña);

            return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
