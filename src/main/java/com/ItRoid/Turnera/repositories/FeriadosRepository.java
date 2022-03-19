package com.ItRoid.Turnera.repositories;

import com.ItRoid.Turnera.entities.FeriadosEntity;
import com.ItRoid.Turnera.entities.HorariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeriadosRepository extends JpaRepository<FeriadosEntity, Long> {

}
