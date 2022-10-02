package com.example.league_manager_backend.controller;

import com.example.league_manager_backend.model.Game;
import com.example.league_manager_backend.model.GameDay;
import com.example.league_manager_backend.model.LeagueData;
import com.example.league_manager_backend.model.Team;
import com.example.league_manager_backend.repository.GameDayRepository;
import com.example.league_manager_backend.security.services.LeagueCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        return new ResponseEntity<>(gameDayRepository.findByNumber(number), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity createLeague(@RequestBody Map<String, Object> data) {
        List<Integer> ids = (List<Integer>) data.get("ids");
        List<Long> dates = (List<Long>) data.get("dates");
        List<Date> dateList = dates.stream()
                .map(Date::new)
                .collect(Collectors.toList());

        // sort
        Collections.sort(dateList);

        //TODO: mit realen daten arbeiten
        ids.clear();
        for (int i = 19; i < 29; i++) {
            ids.add(i);
        }

        int gameDays = 18;
        dateList.clear();
        Long firstDate = 1664575200000L;

        for (int i = 0; i < gameDays; i++) {
            Date date = new Date(firstDate);
            dateList.add(date);
            firstDate = firstDate + 86400000;
        }

        
        logger.info("CREATE league - IDs: " + ids + " - Dates: " + dateList);
        leagueCreator.createLeague(ids, dateList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
