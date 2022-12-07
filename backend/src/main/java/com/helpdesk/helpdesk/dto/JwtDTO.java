package com.helpdesk.helpdesk.dto;


import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDTO {

    private String token;
    private String bearer = "Bearer";
    private String correo;

    public JwtDTO(String token, String correo) {
        this.token = token;
        this.correo = correo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
