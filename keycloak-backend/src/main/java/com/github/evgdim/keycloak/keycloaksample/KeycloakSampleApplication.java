package com.github.evgdim.keycloak.keycloaksample;

import org.keycloak.adapters.servlet.KeycloakOIDCFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeycloakSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakSampleApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean keycloakFilter() {
		FilterRegistrationBean<KeycloakOIDCFilter> registrationBean
				= new FilterRegistrationBean<>();
		KeycloakOIDCFilter filter = new KeycloakOIDCFilter();

		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("/*");
		registrationBean.addInitParameter("keycloak.config.file", "D:\\PROJECTS\\GitHub\\keycloak-sample\\keycloak-backend\\src\\main\\resources\\keycloak.json");
		return registrationBean;
	}
}
