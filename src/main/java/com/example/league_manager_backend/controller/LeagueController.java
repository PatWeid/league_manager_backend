package com.example.league_manager_backend.controller;

import com.example.league_manager_backend.model.GameDay;
import com.example.league_manager_backend.model.Match;
import com.example.league_manager_backend.payload.response.MessageResponse;
import com.example.league_manager_backend.repository.GameDayRepository;
import com.example.league_manager_backend.repository.GameRepository;
import com.example.league_manager_backend.security.services.LeagueCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/league")
public class LeagueController {

    private static final Logger logger = LoggerFactory.getLogger("LeagueController.class");

    @Autowired
    private LeagueCreator leagueCreator;

    @Autowired
    private GameDayRepository gameDayRepository;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/gameday/{number}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<GameDay> getGameDay(@PathVariable int number) {
        logger.info("GET gameday - number: " + number);
        return new ResponseEntity<>(gameDayRepository.findByNumber(number), HttpStatus.OK);
    }


    @GetMapping("/{gameId}/matches")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Match>> getMatchesByGame(@PathVariable long gameId) {
        logger.info("GET matches by game - gameID: " + gameId);
        List<Match> matchesByGame = new ArrayList<>(gameRepository.findById(gameId).get().getMatches());
        matchesByGame.sort(Comparator.comparing(Match::getNumber));
        logger.info("MatchesByGameID: " + matchesByGame);
        return new ResponseEntity<>(matchesByGame, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteLeague() {
        // nothing to delete
        if (gameDayRepository.findAll().isEmpty()) {
            logger.info("ERROR DELETE league - There is no League to delete.");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("There is no League to delete."));
        }
        logger.info("DELETE league");
        try {
            gameDayRepository.deleteAll();
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createLeague(@RequestBody Map<String, Object> data) {
        // there is already a league
        if (!gameDayRepository.findAll().isEmpty()) {
            logger.info("ERROR CREATE new league - there is already one.");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("There is already a league. Delete it first."));
        }
        List<Integer> ids = (List<Integer>) data.get("ids");
        // check ids for uniqeness
        Set<Integer> idSet = new HashSet<>(ids);
        if (!(ids.size() == idSet.size())) {
            // there are duplicates
            logger.info("ERROR CREATE new league - duplicate team ids");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Teams are not unique. Please make sure that every team is only added once to the league."));
        }

        List<Long> dates = (List<Long>) data.get("dates");
        // check dates for uniqeness
        Set<Long> dateSet = new HashSet<>(dates);
        if (!(dates.size() == dateSet.size())) {
            // there are duplicates
            logger.info("ERROR CREATE new league - duplicate dates");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Dates are not unique. Please make sure to choose different gamedays."));
        }

        // convert dates
        List<Date> dateList = dates.stream()
                .map(Date::new)
                .collect(Collectors.toList());

        // invalid number of teams or dates
        if (ids.size() != 10 || dateList.size() != 9) {
            logger.info("ERROR CREATE new league - invalid number of teams or dates.");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Invalid number of teams or dates."));
        }

        // sort dates
        Collections.sort(dateList);

        logger.info("CREATE new league. IDs: " + ids + " - Dates: " + dateList);
        leagueCreator.createLeague(ids, dateList);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
