package com.helpdesk.helpdesk.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaPrincipal implements UserDetails {

    private String nombre;
    private String telefono;
    private String correo;
    private String clave;

    public PersonaPrincipal(String nombre, String telefono, String correo, String clave) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public static PersonaPrincipal build(Persona persona){
        return new PersonaPrincipal(persona.getNombre(), persona.getTelefono(), persona.getCorreo(),
                persona.getClave());
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
