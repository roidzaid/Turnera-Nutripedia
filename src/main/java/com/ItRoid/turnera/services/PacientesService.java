package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.PacienteModel;

public interface PacientesService<T>{

    PacienteModel crearPaciente (PacienteModel paciente) throws Exception;
    PacienteModel BuscarPaciente (String dni);
    PacienteModel BuscarPacientexId (Long id);
    PacienteModel modificarPaciente (PacienteModel paciente) throws Exception;

}
