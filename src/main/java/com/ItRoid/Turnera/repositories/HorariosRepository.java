package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.HorariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<HorariosEntity, Long> {

    @Query(
            value = "SELECT * FROM horarios h WHERE h.id_horario = ?1",
            nativeQuery = true)
    HorariosEntity findByIdHorarios(Long idHorarios);

    @Query(
            value = "SELECT * FROM horarios h WHERE h.id_Profesional = ?1",
            nativeQuery = true)
    List<HorariosEntity> findByIdProfesional(Long idProfesional);

    @Query(
            value = "SELECT * FROM horarios h WHERE h.id_Profesional = ?1 and h.tipo_turno = ?2",
            nativeQuery = true)
    List<HorariosEntity> findByIdProfesionalYTipoTurno(Long idProfesional, String tipoTurno);

    @Query(
            value = "SELECT h.tipo_turno FROM horarios h WHERE h.id_Profesional = ?1 group by tipo_turno;",
            nativeQuery = true)
    List<String> findTipoTurnos(Long idProfesional);

    @Query(
            value = "SELECT dia_de_semana FROM horarios h WHERE h.id_Profesional = ?1 group by dia_de_semana;",
            nativeQuery = true)
    List<String> diasAtencion(Long idProfesional);

    @Query(
            value = "SELECT * FROM horarios h WHERE h.id_Profesional = ?1 and h.fecha_horario_eventual = ?2",
            nativeQuery = true)
    HorariosEntity esHoararioEventual(Long idProfesional, String fechaHorarioEventual);

}
