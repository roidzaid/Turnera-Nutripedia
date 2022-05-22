package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.ConfiguracionTurnosEntity;
import com.ItRoid.Turnera.entities.TurnoAsignadoEntity;
import com.ItRoid.Turnera.models.TurnoAsignadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface TurnosAsignadosRepository extends JpaRepository<TurnoAsignadoEntity, Long> {

    @Query(
            value = "SELECT * FROM turnos_asignados ta WHERE ta.fecha = ?1 and ta.id_configuracion_turno = ?2",
            nativeQuery = true)
    TurnoAsignadoEntity findByTurnosAsignados(String fecha, Long idConfiguracionTurnos);

    @Query(
            value = "SELECT * FROM turnos_asignados ta WHERE ta.dni_paciente = ?1 and fechay_hora > ?2 order by fechay_hora",
            nativeQuery = true)
    List<TurnoAsignadoEntity> buscarMisTurnos(String dni_Paciente, String fechayHora);

    @Query(
            value = "SELECT * FROM turnos_asignados ta WHERE ta.id_profesional = ?1 and fechay_hora > ?2 order by fechay_hora",
            nativeQuery = true)
    List<TurnoAsignadoEntity> buscarAgenda(Long idProfesional, String fechayHora);

    @Query(
            value = "SELECT * FROM turnos_asignados ta WHERE ta.id_profesional = ?1 and fechay_hora >= ?2 and fechay_hora <= ?3 order by fechay_hora",
            nativeQuery = true)
    List<TurnoAsignadoEntity> buscarAgendaPorFecha(Long idProfesional, String inicioDia, String finDia);


    @Query(
            value = "SELECT * FROM turnos_asignados ta WHERE ta.id_turno_asignado = ?1",
            nativeQuery = true)
    TurnoAsignadoEntity buscarTurnoXId(Long idTurnoAsignado);


}
