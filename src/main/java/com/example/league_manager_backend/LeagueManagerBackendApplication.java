package com.example.league_manager_backend;

import com.example.league_manager_backend.controller.AuthController;
import com.example.league_manager_backend.controller.TeamController;
import com.example.league_manager_backend.model.ERole;
import com.example.league_manager_backend.model.Role;
import com.example.league_manager_backend.model.Team;
import com.example.league_manager_backend.model.User;
import com.example.league_manager_backend.payload.request.SignupRequest;
import com.example.league_manager_backend.repository.TeamRepository;
import com.example.league_manager_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.*;

@SpringBootApplication
public class LeagueManagerBackendApplication {

    private static final Logger logger = LoggerFactory.getLogger("LeagueManagerBackendApplication.class");

    public static void main(String[] args) {
        SpringApplication.run(LeagueManagerBackendApplication.class, args);
    }


//    @Bean
//    CommandLineRunner initDataBase(UserRepository userRepository, AuthController authController, TeamController teamController) {
//        Set<String> role = new HashSet<>();
//        role.add("user");
//        SignupRequest signupRequest = new SignupRequest();
//        signupRequest.setUsername("user10");
//        signupRequest.setEmail("user10@web.de");
//        signupRequest.setPassword("user10");
//        signupRequest.setRole(role);
//        authController.registerUser(signupRequest);
//        User user = userRepository.findByUsername("user10").get();
//        System.out.println("--------user: " + user.getId());
//        Team team = new Team(user, "user10-team", "10d1", "10d2", "10d3", "10p1", "10p2", "10p3", "10p4", "10p5", "10p6");
//        try {
//            teamController.createTeam(user.getId(), team);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
////        teamRepository.save(team);
////        for (int i = 1; i < 11; i++) {
////            signupRequest.setUsername("user" + i);
////            signupRequest.setEmail("user" + i + "@tabletennis.com");
////            signupRequest.setPassword("user" + i);
////            signupRequest.setRole(role);
////            authController.registerUser(signupRequest);
////        }
//        return args -> {
////            logger.info("prefill DB: " + userRepository.save(new User("user1", "user1@tabletennis.com", "$2a$10$HRSff62HfqujZEtF6peuIe/96qx69TAR6gVs3AAumtd4MA/90kMAa")));
//
//
//        };
//    }

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
