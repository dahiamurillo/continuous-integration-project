package com.helpdesk.helpdesk.controller;

import com.helpdesk.helpdesk.dto.JwtDTO;
import com.helpdesk.helpdesk.dto.LoginUsuario;
import com.helpdesk.helpdesk.dto.Mensaje;
import com.helpdesk.helpdesk.dto.NuevoUsuario;
import com.helpdesk.helpdesk.entity.Persona;
import com.helpdesk.helpdesk.security.jwt.JwtProvider;
import com.helpdesk.helpdesk.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonaService personaService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/auth/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevaPersona, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if (personaService.existsByCorreo(nuevaPersona.getCorreo()))
            return new ResponseEntity<>(new Mensaje("El correo electrónico ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
        Persona persona =
                new Persona(nuevaPersona.getNombre(), nuevaPersona.getTelefono(),
                        nuevaPersona.getCorreo(), passwordEncoder.encode(nuevaPersona.getClave()));
        System.out.println(persona.getCorreo() + " " + persona.getClave());
        personaService.save(persona);
        System.out.println("createddddd");
        return new ResponseEntity<>(new Mensaje("Usuario creado exitosamente"), HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Los datos son incorrectos"), HttpStatus.BAD_REQUEST);
        List<Persona> list = personaService.list();
        for(Persona persona: list){
            System.out.println("persona " + persona.getCorreo() + " clave: " + persona.getClave());
        }
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getCorreo(),
                        loginUsuario.getClave()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generarToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
