package com.example.league_manager_backend.controller;

import com.example.league_manager_backend.model.GameDay;
import com.example.league_manager_backend.payload.response.MessageResponse;
import com.example.league_manager_backend.repository.GameDayRepository;
import com.example.league_manager_backend.security.services.LeagueCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

//    @GetMapping("/gameday/{number}")
//    public ResponseEntity<Map<String, String>> getGameDay(@PathVariable int number) {
//        logger.info("GET gameday by number: " + number);
//        Map<String, String> response = new HashMap<>();
//        GameDay gameDay = gameDayRepository.findByNumber(number);
//        List<Game> games = new ArrayList<>(gameDay.getGames());
//        Game game1 = games.get(0);
//        response.put("idgame1", String.valueOf(game1.getId()));
//        List<Team> teams = new ArrayList<>(game1.getTeams());
//        Team game1Team1 = teams.get(0);
//        Team game1Team2 = teams.get(1);
//        response.put("game1team1", game1Team1.getName());
//        response.put("game1team2", game1Team2.getName());
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @GetMapping("/gameday/{number}")
    public ResponseEntity<GameDay> getGameDay(@PathVariable int number) {
        logger.info("GET gameday - number: " + number);
        return new ResponseEntity<>(gameDayRepository.findByNumber(number), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteLeague() {
        //nothing to delete
        if (gameDayRepository.findAll().isEmpty()) {
            logger.info("ERROR DELETE league - There is no League to delete");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("There is no League to delete"));
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
    public ResponseEntity createLeague(@RequestBody Map<String, Object> data) {
        // there is already a league
        if (!gameDayRepository.findAll().isEmpty()) {
            logger.info("ERROR CREATE new league - there is already one");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("There is already a league. Delete it first"));
        }
        List<Integer> ids = (List<Integer>) data.get("ids");
        List<Long> dates = (List<Long>) data.get("dates");
        List<Date> dateList = dates.stream()
                .map(Date::new)
                .collect(Collectors.toList());

        // invalid number of teams or dates
        if (ids.size() != 10 || dateList.size() != 9) {
            logger.info("ERROR CREATE new league - invalid number of teams or dates");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Invalid number of teams or dates"));
        }

        // sort
        Collections.sort(dateList);

        logger.info("CREATE new league");
        logger.info("IDs: " + ids);
        logger.info("Dates: " + dateList);

        //TODO: mit realen daten arbeiten
//        ids.clear();
//        for (int i = 19; i < 29; i++) {
//            ids.add(i);
//        }
//
//        int gameDays = 9;
//        dateList.clear();
//        Long firstDate = 1664575200000L;
//
//        for (int i = 0; i < gameDays; i++) {
//            Date date = new Date(firstDate);
//            dateList.add(date);
//            firstDate = firstDate + 86400000;
//        }
//
//
//        logger.info("CREATE league - IDs: " + ids + " - Dates: " + dateList);
        leagueCreator.createLeague(ids, dateList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
