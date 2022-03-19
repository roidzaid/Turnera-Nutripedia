package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.*;
import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.models.TurnoAsignadoModel;
import com.ItRoid.Turnera.models.TurnosDisponiblesModel;
import com.ItRoid.Turnera.repositories.*;
import com.ItRoid.Turnera.services.HorariosService;
import com.ItRoid.Turnera.services.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnosServiceImpl implements TurnosService {

    @Autowired
    private TurnosAsignadosRepository turnosAsignadosRepository;

    @Autowired
    private ConfiguracionTurnosRepository configuracionTurnosRepository;

    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private ProfesionalesRepository profesionalesRepository;

    @Autowired
    private PacientesRepository pacientesRepository;


    @Override
    public void asignarTurno(AsignarTurnoModel asignarTurnoModel) throws ParseException {

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByidProfesional(asignarTurnoModel.getIdProfesional());

        PacienteEntity pacienteEntity = this.pacientesRepository.findByIdPaciente(asignarTurnoModel.getIdPaciente());

        ConfiguracionTurnosEntity configuracionTurnosEntity = this.configuracionTurnosRepository.findByIdConfiguracionTurno(asignarTurnoModel.getIdConfiguracionTurno());

       String[] horaSplit = configuracionTurnosEntity.getHora().split(":", 2);

        int hora = Integer.parseInt(horaSplit[0]);
        int minutos = Integer.parseInt(horaSplit[1]);

        String[] fechaSplit = asignarTurnoModel.getFecha().split("-", 3);

        int dia = Integer.parseInt(fechaSplit[0]);
        int mes = Integer.parseInt(fechaSplit[1]);
        int año = Integer.parseInt(fechaSplit[2]);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes - 1);
        calendar.set(Calendar.YEAR, año);
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minutos);
        calendar.set(Calendar.SECOND, 00);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String fecha = format.format(calendar.getTime());

        TurnoAsignadoEntity turnoAsignadoEntity = new TurnoAsignadoEntity(
                configuracionTurnosEntity.getIdConfiguracionTurnos(),
                asignarTurnoModel.getFecha(),
                configuracionTurnosEntity.getHora(),
                fecha,
                profesionalEntity.getIdProfesional(),
                profesionalEntity.getNombre(),
                profesionalEntity.getApellido(),
                asignarTurnoModel.getEspecialidad(),
                profesionalEntity.getMail(),
                pacienteEntity.getIdPaciente(),
                pacienteEntity.getNombre(),
                pacienteEntity.getApellido(),
                pacienteEntity.getDni(),
                pacienteEntity.getTelefono(),
                pacienteEntity.getMail());

        this.turnosAsignadosRepository.save(turnoAsignadoEntity);

    }

    @Override
    public List<TurnosDisponiblesModel> turnosDisponibles(String fecha, Long idHorario) throws Exception {

        //traigo config de turnos
        List<ConfiguracionTurnosEntity> turnosPosibles = this.configuracionTurnosRepository.findByConfiguracionTurnos(idHorario);

        //traigo horario
        HorariosEntity horariosEntity = this.horariosRepository.findByIdHorarios(idHorario);

        List<TurnosDisponiblesModel> turnosLibre = new ArrayList<>();

        for(int i = 0; turnosPosibles.size() > i; i++){

            TurnoAsignadoEntity turnoAsignado =  this.turnosAsignadosRepository.findByTurnosAsignados(fecha, turnosPosibles.get(i).getIdConfiguracionTurnos());

            if (turnoAsignado == null){

                TurnosDisponiblesModel turnoDisponible = new TurnosDisponiblesModel(
                        turnosPosibles.get(i).getIdConfiguracionTurnos(),
                        horariosEntity.getDiaDeSemana(),
                        fecha,
                        turnosPosibles.get(i).getHora());


                turnosLibre.add(turnoDisponible);

            }
        }

        return turnosLibre;

    }

    @Override
    public List<TurnoAsignadoModel> misTurnos(String dni_Paciente) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar calendar = Calendar.getInstance();

        String fechayHora = format.format(calendar.getTime());

        List<TurnoAsignadoEntity> turnoAsignadoEntity = this.turnosAsignadosRepository.buscarMisTurnos(dni_Paciente, fechayHora);

        List<TurnoAsignadoModel> list = turnoAsignadoEntity
                .stream()
                .map((e) -> new TurnoAsignadoModel(
                        e.getIdTurnoAsignado(),
                        e.getIdConfiguracionTurno(),
                        e.getFecha(),
                        e.getHora(),
                        e.getIdProfesional(),
                        e.getNombreProfesional(),
                        e.getApellidoProfesional(),
                        e.getEspecialidad(),
                        e.getMailProfesional(),
                        e.getIdPaciente(),
                        e.getNombrePaciente(),
                        e.getApellidoPaciente(),
                        e.getDniPaciente(),
                        e.getTelefonoPaciente(),
                        e.getMailPaciente()))
                .collect(Collectors.toList());

        return list;

    }
}
