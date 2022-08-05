package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.HorariosEntity;
import com.ItRoid.Turnera.entities.ProfesionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionalesRepository extends JpaRepository<ProfesionalEntity, Long> {

    @Query(
            value = "SELECT * FROM profesionales pro WHERE pro.id_Profesional = ?1",
            nativeQuery = true)
    ProfesionalEntity findByidProfesional(Long idProfesional);

    @Query(
            value = "SELECT * FROM profesionales pro WHERE pro.dni = ?1",
            nativeQuery = true)
    ProfesionalEntity findByDni(String dni);

    @Query(
            value = "SELECT * FROM profesionales pro WHERE pro.nombre = ?1 and pro.apellido = ?2",
            nativeQuery = true)
    List<ProfesionalEntity> findByNomYApe(String nombre, String apellido);

    @Query(
            value = "SELECT * FROM profesionales pro WHERE pro.especialidad = ?1",
            nativeQuery = true)
    List<ProfesionalEntity> findByEspecialidad(String especialidad);

    @Query(
            value = "SELECT * FROM profesionales pro WHERE pro.usuario = ?1",
            nativeQuery = true)
    ProfesionalEntity findByUsuario(String usuario);


    @Query(
            value = "SELECT * FROM horarios h WHERE h.id_consultorio = ?1 and h.dia_de_semana = ?2 and h.hora_desde = ?3",
            nativeQuery = true)
    HorariosEntity findHorario(Long idConsultorio, String diaDeSemama, int hora_desde);



}
