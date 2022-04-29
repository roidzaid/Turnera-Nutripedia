package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.TipoTurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTurnoRespository extends JpaRepository<TipoTurnoEntity, Long> {
}
