package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.EspecialidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRespository extends JpaRepository<EspecialidadEntity, Long> {
}
