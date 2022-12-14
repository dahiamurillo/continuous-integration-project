package com.helpdesk.helpdesk.service;

import com.helpdesk.helpdesk.entity.Persona;
import com.helpdesk.helpdesk.entity.PersonaPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonaDetalleService implements UserDetailsService {

    @Autowired
    PersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Persona persona = personaService.getOne(correo).get();
        return PersonaPrincipal.build(persona);
    }
}