package com.ItRoid.turnera.services.Impl;

import com.ItRoid.turnera.entities.PacienteEntity;
import com.ItRoid.turnera.models.PacienteModel;
import com.ItRoid.turnera.repositories.PacientesRepository;
import com.ItRoid.turnera.services.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PacientesServiceImpl implements PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;


    @Override
    public PacienteModel crearPaciente(PacienteModel paciente) throws Exception {

        PacienteEntity pe = this.pacientesRepository.findByDNI(paciente.getDni());

        if(pe==null) {
            PacienteEntity pacienteEntity = new PacienteEntity(
                    Date.from(Instant.now()),
                    paciente.getNombre(),
                    paciente.getApellido(),
                    paciente.getDni(),
                    paciente.getFechaNac(),
                    paciente.getDireccion(),
                    paciente.getLocalidad(),
                    paciente.getTelefono(),
                    paciente.getMail());


            this.pacientesRepository.save(pacienteEntity);

            return paciente;
        }else{
            throw new Exception("Ya fue dado de alta " + paciente.getApellido() + ", " + paciente.getNombre());
        }

    }

    @Override
    public PacienteModel BuscarPaciente(String dni) {

        PacienteEntity pacienteEntity = this.pacientesRepository.findByDNI(dni);

        if (pacienteEntity != null){
            PacienteModel pacienteModel = new PacienteModel(
                    pacienteEntity.getIdPaciente(),
                    pacienteEntity.getNombre(),
                    pacienteEntity.getApellido(),
                    pacienteEntity.getDni(),
                    pacienteEntity.getFechaNac(),
                    pacienteEntity.getDireccion(),
                    pacienteEntity.getLocalidad(),
                    pacienteEntity.getTelefono(),
                    pacienteEntity.getMail());

            return pacienteModel;
        }else{
            return null;
        }

    }

    @Override
    public PacienteModel BuscarPacientexId(Long idPaciente) {

        PacienteEntity pacienteEntity = this.pacientesRepository.findByIdPaciente(idPaciente);

        if (pacienteEntity != null){
            PacienteModel pacienteModel = new PacienteModel(
                    pacienteEntity.getIdPaciente(),
                    pacienteEntity.getNombre(),
                    pacienteEntity.getApellido(),
                    pacienteEntity.getDni(),
                    pacienteEntity.getFechaNac(),
                    pacienteEntity.getDireccion(),
                    pacienteEntity.getLocalidad(),
                    pacienteEntity.getTelefono(),
                    pacienteEntity.getMail());

            return pacienteModel;
        }else{
            return null;
        }

    }

    @Override
    public PacienteModel modificarPaciente(PacienteModel paciente) throws Exception {

        PacienteEntity pe = this.pacientesRepository.findByIdPaciente(paciente.getIdPaciente());

        if(pe!=null) {

            pe.setFechaAlta(Date.from(Instant.now()));
            pe.setNombre(paciente.getNombre());
            pe.setApellido(paciente.getApellido());
            pe.setDni(paciente.getDni());
            pe.setFechaNac(paciente.getFechaNac());
            pe.setDireccion(paciente.getDireccion());
            pe.setLocalidad(paciente.getLocalidad());
            pe.setTelefono(paciente.getTelefono());
            pe.setMail(paciente.getMail());

            this.pacientesRepository.save(pe);

            return paciente;
        }else{
            throw new Exception("el paciente no existe");
        }
    }
}
