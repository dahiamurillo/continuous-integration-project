package com.helpdesk.helpdesk.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NuevoUsuario {

    @NotBlank
    private String clave;
    @NotBlank
    @Email
    private String correo;
    @NotBlank
    private String nombre;
    @NotBlank
    private String telefono;

    private String rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
