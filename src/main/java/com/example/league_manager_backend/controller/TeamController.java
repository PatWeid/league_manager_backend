package com.example.league_manager_backend.controller;

import com.example.league_manager_backend.model.Team;
import com.example.league_manager_backend.model.User;
import com.example.league_manager_backend.repository.TeamRepository;
import com.example.league_manager_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger("TeamController.class");

    @GetMapping({ "/user/{id}/team" })
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long id) throws Exception {

        Team team = teamRepository.findByUserId(id);
        System.out.println("get team: " + team);

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @GetMapping({ "/teams" })
    public ResponseEntity<List<Team>> getAllTeams() throws Exception {

        List<Team> allTeams = teamRepository.findAll();
        logger.info("GET all teams: " + allTeams);
        return new ResponseEntity<>(allTeams, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/team")
    public ResponseEntity<Team> createTeam(@PathVariable(value = "userId") Long userId,
                                           @RequestBody Team team) throws Exception {
        System.out.println("create team");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception());

        team.setUser(user);
        teamRepository.save(team);

        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}/team")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "userId") Long userId,
                                           @RequestBody Team team) {
        System.out.println("update Team" + "userid: " + userId + "team: " + team);
        Team oldTeam = teamRepository.findByUserId(userId);
        oldTeam.setName(team.getName());
        oldTeam.setDouble1(team.getDouble1());
        oldTeam.setDouble2(team.getDouble2());
        oldTeam.setDouble3(team.getDouble3());
        oldTeam.setPlayer1(team.getPlayer1());
        oldTeam.setPlayer2(team.getPlayer2());
        oldTeam.setPlayer3(team.getPlayer3());
        oldTeam.setPlayer4(team.getPlayer4());
        oldTeam.setPlayer5(team.getPlayer5());
        oldTeam.setPlayer6(team.getPlayer6());
        return new ResponseEntity<>(teamRepository.save(oldTeam), HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}/team")
    public ResponseEntity<Team> deleteTeam(@PathVariable(value = "userId") Long userId) {
        System.out.println("delete team");
        teamRepository.deleteByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
