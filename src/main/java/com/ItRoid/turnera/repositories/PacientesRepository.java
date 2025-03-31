package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<PacienteEntity, Long> {

    @Query(
            value = "SELECT * FROM pacientes p WHERE p.id_paciente = ?1",
            nativeQuery = true)
    PacienteEntity findByIdPaciente(Long idPaciente);

    @Query(
            value = "SELECT * FROM pacientes p WHERE p.dni = ?1",
            nativeQuery = true)
    PacienteEntity findByDNI(String dni);

}
