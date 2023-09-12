package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.PacienteModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.models.ValorConsultaModel;
import com.ItRoid.Turnera.services.ValorConsultaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("valorConsulta")
public class ValorConsultaController {

    Logger logger = LoggerFactory.getLogger(ValorConsultaController.class);

    @Autowired
    private ValorConsultaService valorConsultaService;

    //Pacientes
//************************
    @PostMapping()
    public ResponseEntity<?> createValorConsulta(@RequestBody ValorConsultaModel valorConsultaModel) throws Exception {

        logger.info("Se da alta valor para consulta " + valorConsultaModel.getTipoConsulta() + " de " + valorConsultaModel.getIdProfesional());

        try {
            ValorConsultaModel v = this.valorConsultaService.crearValorConsulta(valorConsultaModel);

            return new ResponseEntity<ValorConsultaModel>(v, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/valor/{idValorConsulta}")
    public ResponseEntity<?> buscarValorConsulta(@PathVariable("idValorConsulta") Long idValorConsulta) throws Exception {

        logger.info("Se busca valor de la consulta : " + idValorConsulta);

        try {

            ValorConsultaModel valorConsultaModel = this.valorConsultaService.buscarValorconsulta(idValorConsulta);

            return new ResponseEntity<ValorConsultaModel>(valorConsultaModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/valor/{idprofesional}/{tipo_consuta}")
    public ResponseEntity<?> buscarValorConsulta(@PathVariable("idprofesional") Long idprofesional, @PathVariable("tipo_consuta") String tipo_consuta) throws Exception {

        logger.info("Se busca valor de la consulta para " + idprofesional);

        try {

            ValorConsultaModel valorConsultaModel = this.valorConsultaService.buscarValorconsulta(idprofesional, tipo_consuta);

            return new ResponseEntity<ValorConsultaModel>(valorConsultaModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/{idProfesional}")
    public ResponseEntity<?> listaValoresConsultas(@PathVariable("idProfesional") Long idProfesional) throws Exception {

        logger.info("Se busca todos los valores por tipo de consulta de: " + idProfesional);

        try {

            List<ValorConsultaModel> list = this.valorConsultaService.buscarAll(idProfesional);

            return new ResponseEntity<List<ValorConsultaModel>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idValorConsulta}")
    public ResponseEntity<?> modificarValorConsulta(@RequestBody ValorConsultaModel valorConsultaModel, @PathVariable("idValorConsulta") Long idValorConsulta) throws Exception  {

        logger.info("Se modifica el valos de la consulta: " + idValorConsulta);

        try {

            ValorConsultaModel v = this.valorConsultaService.modifValorConsuta(idValorConsulta, valorConsultaModel);

            return new ResponseEntity<ValorConsultaModel>(v,    HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idValorConsulta}")
    public ResponseEntity<?> borrarProfesional(@PathVariable("idValorConsulta") Long idValorConsulta) throws Exception  {

        logger.info("Se elimina el el valor de la consulta: " + idValorConsulta);

        try {
            this.valorConsultaService.deleteValorConsulta(idValorConsulta);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}