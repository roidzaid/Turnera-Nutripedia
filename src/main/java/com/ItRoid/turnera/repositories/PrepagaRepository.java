package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.PrepagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrepagaRepository extends JpaRepository<PrepagaEntity, Long> {

    @Query(
            value = "SELECT * FROM prepagas p WHERE p.prepaga = ?1 and p.id_profesional = ?2",
            nativeQuery = true)
    PrepagaEntity getByPrepagaProf(String prepaga, Long idProfesional);


    @Query(
            value = "SELECT * FROM prepagas p WHERE p.id_profesional = ?1",
            nativeQuery = true)
    List<PrepagaEntity> getByProfesinal(Long idProfesional);

    @Query(
            value = "SELECT * FROM prepagas p WHERE p.id_prepaga = ?1",
            nativeQuery = true)
    PrepagaEntity getById(Long IdPrepaga);


}
