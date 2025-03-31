package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.FeriadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriadosRepository extends JpaRepository<FeriadosEntity, Long> {

}
