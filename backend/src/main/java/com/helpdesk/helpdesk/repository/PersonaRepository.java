package com.helpdesk.helpdesk.repository;

import com.helpdesk.helpdesk.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Optional<Persona> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

}
