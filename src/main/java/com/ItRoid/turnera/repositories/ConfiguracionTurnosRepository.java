package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.ConfiguracionTurnosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionTurnosRepository  extends JpaRepository<ConfiguracionTurnosEntity, Long> {

    @Query(
            value = "SELECT * FROM configuracion_turnos h WHERE h.id_configuracion_turnos = ?1",
            nativeQuery = true)
    ConfiguracionTurnosEntity findByIdConfiguracionTurno(Long idConfiguracionTurno);


    @Query(
            value = "SELECT * FROM configuracion_turnos h WHERE h.id_horario = ?1",
            nativeQuery = true)
    List<ConfiguracionTurnosEntity> findByConfiguracionTurnos(Long idHorario);
}
