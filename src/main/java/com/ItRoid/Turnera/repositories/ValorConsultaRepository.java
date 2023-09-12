package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.HorariosEntity;
import com.ItRoid.Turnera.entities.ValorConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ValorConsultaRepository extends JpaRepository<ValorConsultaEntity, Long> {

    @Query(
            value = "SELECT * FROM valor_consulta vc WHERE vc.id_valor_consulta = ?1",
            nativeQuery = true)
    ValorConsultaEntity findByIdValorConsulta(Long idValorConsutla);

    @Query(
            value = "SELECT * FROM valor_consulta vc WHERE vc.id_profesional = ?1 and vc.tipo_consulta = ?2",
            nativeQuery = true)
    ValorConsultaEntity findByIdValorConsulta(Long idProfesional, String tipo_consuta);

    @Query(
            value = "SELECT * FROM valor_consulta vc WHERE vc.id_Profesional = ?1",
            nativeQuery = true)
    List<ValorConsultaEntity> findByIdProfesional(Long idProfesional);


    @Query(
            value = "SELECT * FROM valor_consulta vc WHERE vc.id_Profesional = ?1 FETCH FIRST 1 ROW ONLY",
            nativeQuery = true)
    ValorConsultaEntity findPrimerValor(Long idProfesional);

}
