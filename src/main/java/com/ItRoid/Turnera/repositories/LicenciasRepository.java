package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.LicenciasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LicenciasRepository extends JpaRepository<LicenciasEntity, Long> {

    @Query(
            value = "SELECT * FROM licencias l WHERE l.id_licencia = ?1",
            nativeQuery = true)
    LicenciasEntity findByIdLicencia(Long idLicencia);

    @Query(
            value = "SELECT * FROM licencias l WHERE l.id_profesional = ?1 and l.id_licencia = ?2 ",
            nativeQuery = true)
    LicenciasEntity findByidProfesionalYIdLicencia(Long idProfesional, Long idLicencia);


    @Query(
            value = "SELECT * FROM licencias l WHERE l.id_profesional = ?1 and l.dia_date >= ?2",
            nativeQuery = true)
    List<LicenciasEntity> findByIdProfesional(Long idProfesional, Date diaDesde);

    @Query(
            value = "SELECT * FROM licencias l WHERE l.id_profesional = ?1 and l.dia = ?2",
            nativeQuery = true)
    String findByIdProfesionalYDia(Long idProfesional, String dia);

    @Query(
            value = "SELECT * FROM licencias l WHERE l.id_profesional = ?1 and l.dia_Desde = ?2 and l.dia_Hasta = ?3",
            nativeQuery = true)
    List<LicenciasEntity> findByFechas(Long idProfesional, String fechaDesde, String fechaHasta);

}
