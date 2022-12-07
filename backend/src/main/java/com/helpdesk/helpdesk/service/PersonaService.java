package com.helpdesk.helpdesk.service;

import com.helpdesk.helpdesk.entity.Persona;
import com.helpdesk.helpdesk.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> list(){
        return personaRepository.findAll();
    }

    public Optional<Persona> getOne(String correo) {
        return personaRepository.findByCorreo(correo);
    }

    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    public boolean existsByCorreo(String correo) {
        return personaRepository.existsByCorreo(correo);
    }

}
