package com.github.evgdim.keycloak.keycloaksample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MainController {
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);
    @GetMapping
    public String index(HttpServletRequest req) {
        Map<String, String> headers = Collections.list(req.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(
                        headerName -> headerName,
                        headerName -> req.getHeader((String) headerName)
                        )
                );
        logger.info("headers: {}", headers.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("\n")));
        return "index";
    }
}
