package com.example.league_manager_backend;

import com.example.league_manager_backend.controller.AuthController;
import com.example.league_manager_backend.payload.request.SignupRequest;
import com.example.league_manager_backend.repository.RoleRepository;
import com.example.league_manager_backend.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LeagueManagerBackendApplication {

    private static final Logger logger = LoggerFactory.getLogger("LeagueManagerBackendApplication.class");

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(LeagueManagerBackendApplication.class, args);
    }


    @Bean
    CommandLineRunner initDataBase(AuthController authController) {
        // prefill DB with user1-user10
        Set<String> role = new HashSet<>();
        role.add("user");
        SignupRequest signupRequest = new SignupRequest();
        for (int i = 1; i < 11; i++) {
            signupRequest.setUsername("user" + i);
            signupRequest.setEmail("user" + i + "@tabletennis.com");
            signupRequest.setPassword("user" + i);
            signupRequest.setRole(role);
            authController.registerUser(signupRequest);
        }
        logger.info("Prefill Database with user1-user10");

        // prefill DB with administrator
        role.add("admin");
        signupRequest.setUsername("administrator");
        signupRequest.setEmail("administrator@tabletennis.com");
        signupRequest.setPassword("administrator");
        signupRequest.setRole(role);
        authController.registerUser(signupRequest);
        logger.info("Prefill Database with administrator");

        // prefill DB with admin
        signupRequest.setUsername("admin");
        signupRequest.setEmail("admin@tabletennis.com");
        signupRequest.setPassword("admin");
        signupRequest.setRole(role);
        authController.registerUser(signupRequest);
        logger.info("Prefill Database with admin");

        return args -> {
        };
    }

    // Fix the CORS errors
    @Bean
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // *** URL below needs to match the Vue client URL and port ***
        config.setAllowedOrigins(Collections.singletonList("http://localhost:8081"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
