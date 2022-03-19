package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.ConfiguracionTurnosEntity;
import com.ItRoid.Turnera.entities.HorariosEntity;
import com.ItRoid.Turnera.entities.ProfesionalEntity;
import com.ItRoid.Turnera.models.HorariosModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.repositories.ProfesionalesRepository;
import com.ItRoid.Turnera.services.ProfesionalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesionalesServiceImpl implements ProfesionalesService {

    @Autowired
    private ProfesionalesRepository profesionalesRepository;


//Profecionales

    @Override
    public ProfesionalModel crearProfesional(ProfesionalModel profesional) throws Exception {

        ProfesionalEntity prof = this.profesionalesRepository.findByDni(profesional.getDni());

        if (prof == null) {

            ProfesionalEntity profesionalEntity = new ProfesionalEntity(
                Date.from(Instant.now()),
                profesional.getNombre(),
                profesional.getApellido(),
                profesional.getDni(),
                profesional.getMatricula(),
                profesional.getEspecialidad(),
                profesional.getMail()
                );

            this.profesionalesRepository.save(profesionalEntity);

            return profesional;

        }else{
            throw new Exception("Ya fue dado de alta " + profesional.getApellido() + ", " + profesional.getNombre());
        }

    }

    @Override
    public ProfesionalModel buscarProfesional(String dni) throws Exception {

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByDni(dni);

        if (profesionalEntity != null) {

            ProfesionalModel profesionalModel = new ProfesionalModel(
                    profesionalEntity.getIdProfesional(),
                    profesionalEntity.getNombre(),
                    profesionalEntity.getApellido(),
                    profesionalEntity.getDni(),
                    profesionalEntity.getMatricula(),
                    profesionalEntity.getEspecialidad(),
                    profesionalEntity.getMail());

            return profesionalModel;

        }else{
            throw new Exception("No existe ningun profesional con dni: " +  dni);
        }

    }

    @Override
    public ProfesionalModel buscarProfesionalxId(Long idProfesional) throws Exception {

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByidProfesional(idProfesional);

        if (profesionalEntity != null) {

            ProfesionalModel profesionalModel = new ProfesionalModel(
                    profesionalEntity.getIdProfesional(),
                    profesionalEntity.getNombre(),
                    profesionalEntity.getApellido(),
                    profesionalEntity.getDni(),
                    profesionalEntity.getMatricula(),
                    profesionalEntity.getEspecialidad(),
                    profesionalEntity.getMail());

            return profesionalModel;

        }else{
            throw new Exception("No existe ningun profesional con id: " +  idProfesional);
        }

    }

    @Override
    public List<ProfesionalModel> buscarProfesionalXNomYApe(String nombre, String apellido) throws Exception {

        List<ProfesionalEntity> profesionalEntity = this.profesionalesRepository.findByNomYApe(nombre, apellido);

        if (profesionalEntity != null) {

            List<ProfesionalModel> list = profesionalEntity
                    .stream()
                    .map((e) -> new ProfesionalModel(
                            e.getIdProfesional(),
                            e.getNombre(),
                            e.getApellido(),
                            e.getDni(),
                            e.getMatricula(),
                            e.getEspecialidad(),
                            e.getMail()))
                    .collect(Collectors.toList());


            return list;

        }else{
            throw new Exception("No existe ningun profesional con nombre: " +  apellido + ", " + nombre);
        }
    }

    @Override
    public List<ProfesionalModel> buscarProfesionalXEspecialidad(String especialidad) throws Exception {

        List<ProfesionalEntity> profesionalEntity = this.profesionalesRepository.findByEspecialidad(especialidad);

        if (profesionalEntity != null) {

            List<ProfesionalModel> list = profesionalEntity
                    .stream()
                    .map((e) -> new ProfesionalModel(
                            e.getIdProfesional(),
                            e.getNombre(),
                            e.getApellido(),
                            e.getDni(),
                            e.getMatricula(),
                            e.getEspecialidad(),
                            e.getMail()))
                    .collect(Collectors.toList());


            return list;

        }else{
            throw new Exception("No existe ningun profesional especialidad: " +  especialidad);
        }
    }

    @Override
    public List<ProfesionalModel> buscarProfesionalAll() throws Exception {

        List<ProfesionalEntity> profesionalEntity = this.profesionalesRepository.findAll();

        List<ProfesionalModel> list = profesionalEntity
                .stream()
                .map((e) -> new ProfesionalModel(
                        e.getIdProfesional(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getDni(),
                        e.getMatricula(),
                        e.getEspecialidad(),
                        e.getMail()))
                .collect(Collectors.toList());


        return list;
    }

    @Override
    public ProfesionalModel modificarProfesional(ProfesionalModel profesional, String dni) throws Exception {

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByDni(dni);


        if (profesionalEntity != null) {

            profesionalEntity.setNombre(profesional.getNombre());
            profesionalEntity.setApellido(profesional.getApellido());
            profesionalEntity.setDni(profesional.getDni());
            profesionalEntity.setMatricula(profesional.getMatricula());
            profesionalEntity.setEspecialidad(profesional.getEspecialidad());


            this.profesionalesRepository.save(profesionalEntity);

            return profesional;

        }else{
            throw new Exception("No existe ningun profesional con dni: " +  dni);
        }

    }

    @Override
    public void borrarProfesional(String dni) throws Exception {

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByDni(dni);

        if (profesionalEntity != null) {

            this.profesionalesRepository.delete(profesionalEntity);

        }else{
            throw new Exception("No existe ningun profesional con dni: " +  dni);
        }

    }


    @Override
    public void agregarHorarios(String dni, HorariosModel horario) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Calendar desde = Calendar.getInstance();
        Calendar hasta = Calendar.getInstance();

        //calendar.set(Calendar.AM_PM, Calendar.AM);
        desde.set(Calendar.HOUR, horario.getHoraDesde());
        desde.set(Calendar.MINUTE, horario.getMinutosDesde());
        desde.set(Calendar.SECOND, 00);
        String horaDesde = format.format(desde.getTime());

        //calendar.set(Calendar.AM_PM, Calendar.PM);
        hasta.set(Calendar.HOUR, horario.getHoraHasta());
        hasta.set(Calendar.MINUTE, horario.getMinutosHasta());
        hasta.set(Calendar.SECOND, 00);
        String horaHasta = format.format(hasta.getTime());

        //crea el horario
        HorariosEntity horarioEntity = new HorariosEntity();
        horarioEntity.setFechaAlta(Date.from(Instant.now()));
        horarioEntity.setDiaDeSemana(horario.getDiaDeSemana());
        horarioEntity.setTipoTurno(horario.getTipoTurno());
        horarioEntity.setHoraDesde(horaDesde);
        horarioEntity.setHoraHasta(horaHasta);
        horarioEntity.setDuracionTurnos(horario.getDuracionTurnos());

        //configuracion de turnos
        int horaSig = horario.getHoraDesde();
        int minSig = horario.getMinutosDesde();

        Calendar ultTurno = Calendar.getInstance();

        int añoHoy = Calendar.getInstance().get(Calendar.YEAR);
        int mesHoy = Calendar.getInstance().get(Calendar.MONTH);
        int diaHoy = Calendar.getInstance().get(Calendar.DATE);
        ultTurno.set(añoHoy, mesHoy, diaHoy);

        ultTurno.set(Calendar.AM_PM, Calendar.AM);
        ultTurno.set(Calendar.HOUR, horario.getHoraHasta());
        ultTurno.set(Calendar.MINUTE, horario.getMinutosHasta());

        ultTurno.add(Calendar.MINUTE, -horario.getDuracionTurnos());

        List<ConfiguracionTurnosEntity> listaConfigTurnos = new ArrayList<>();
        boolean ultimo = false;

        Calendar turno = Calendar.getInstance();

        turno.set(añoHoy, mesHoy, diaHoy);

        turno.set(Calendar.AM_PM, Calendar.AM);
        turno.set(Calendar.HOUR, horaSig);
        turno.set(Calendar.MINUTE, minSig);
        turno.set(Calendar.SECOND, 00);

        while (!ultimo) {

            ConfiguracionTurnosEntity configuracionTurnosEntity = new ConfiguracionTurnosEntity();

            String hora = format.format(turno.getTime());

            configuracionTurnosEntity.setHora(hora);

            listaConfigTurnos.add(configuracionTurnosEntity);

            turno.add(Calendar.MINUTE, horario.getDuracionTurnos());

            if (turno.getTime().compareTo(ultTurno.getTime()) > 0) {
                ultimo = true;
            }
        }

        horarioEntity.setConfiguracionTurnos(listaConfigTurnos);

        //busco el profesional
        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByDni(dni);

        //agrego el horario
        profesionalEntity.getHorarios().add(horarioEntity);

        //guardo profesional
        this.profesionalesRepository.save(profesionalEntity);



    }



}
