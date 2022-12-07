package com.helpdesk.helpdesk.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntyPoint implements AuthenticationEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntyPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException {
        logger.error("falla en método commence");
        logger.error("falla en método commence 2 " + e.getMessage());
        logger.error("falla en método commence 3 " + e.getLocalizedMessage());
        logger.error("falla en método commence 4 " + res.getStatus());
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
}
