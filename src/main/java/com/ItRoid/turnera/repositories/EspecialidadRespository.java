package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.EspecialidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRespository extends JpaRepository<EspecialidadEntity, Long> {

    @Query(
            value = "SELECT * FROM especialidades e WHERE e.especialidad = ?1",
            nativeQuery = true)
    EspecialidadEntity findByIdEspecialidad(String especialidad);

    @Query(
            value = "SELECT * FROM especialidades e WHERE e.id_especialidad = ?1",
            nativeQuery = true)
    EspecialidadEntity findByIdEspecialidad(Long idEspecialidad);
}
