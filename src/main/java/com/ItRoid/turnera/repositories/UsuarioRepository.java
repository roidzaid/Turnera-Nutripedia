package com.ItRoid.turnera.repositories;

import com.ItRoid.turnera.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(
            value = "SELECT * FROM usuarios u WHERE u.usuario = ?1 and u.contraseña = ?2",
            nativeQuery = true)
    UsuarioEntity buscarUsuario(String usuario, String contraseña);

    @Query(
            value = "SELECT * FROM usuarios u WHERE u.id_profesional = ?1",
            nativeQuery = true)
    UsuarioEntity buscarUsuarioxIdProfesional(Long idProfesional);


}
