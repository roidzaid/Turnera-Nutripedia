package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.TipoTurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTurnoRespository extends JpaRepository<TipoTurnoEntity, Long> {
}
