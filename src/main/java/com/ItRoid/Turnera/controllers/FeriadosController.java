package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.entities.FeriadosEntity;
import com.ItRoid.Turnera.models.ConfiguracionTurnoModel;
import com.ItRoid.Turnera.models.PacienteModel;
import com.ItRoid.Turnera.services.FeriadosService;
import com.ItRoid.Turnera.services.PacientesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("feriados")
public class FeriadosController {

    Logger logger = LoggerFactory.getLogger(PacientesController.class);

    @Autowired
    private FeriadosService feriadosService;


    @PostMapping()
    public void altaFeriado(@RequestBody List<FeriadosEntity> feriados) throws Exception  {

        logger.info("Se da de alta los feriados");

        for (int i=0;i<feriados.size();i++) {

            FeriadosEntity feriado = new FeriadosEntity(feriados.get(i).getFecha(), feriados.get(i).getDetalle());

            this.feriadosService.crearFeriado(feriado);
        }
    }

    @GetMapping()
    public ResponseEntity<?> listarFeriados() throws Exception{

        logger.info("Se listan los feriados cargados en la BD");

        try {

            List<FeriadosEntity> feriados = this.feriadosService.listarFeriados();

            return new ResponseEntity<List<FeriadosEntity>>(feriados, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
