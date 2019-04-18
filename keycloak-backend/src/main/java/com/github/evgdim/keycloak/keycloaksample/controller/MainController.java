package com.github.evgdim.keycloak.keycloaksample.controller;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.servlet.OIDCServletHttpFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MainController {
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/test")
    public String index(HttpServletRequest req) {
        KeycloakSecurityContext securityContext = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());
        logger.info("KeycloakSecurityContext: {}", securityContext);
        return "index";
    }
}
