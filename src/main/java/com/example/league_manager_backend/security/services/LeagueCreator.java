package com.example.league_manager_backend.security.services;

import com.example.league_manager_backend.model.Game;
import com.example.league_manager_backend.model.GameDay;
import com.example.league_manager_backend.model.Team;
import com.example.league_manager_backend.repository.GameDayRepository;
import com.example.league_manager_backend.repository.GameRepository;
import com.example.league_manager_backend.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeagueCreator {

    private static final Logger logger = LoggerFactory.getLogger("LeagueCreator.class");

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    GameDayRepository gameDayRepository;

    @Autowired
    GameRepository gameRepository;


    public void createLeague(List<Integer> ids, List<Date> dates) {
        logger.info("CREATE League");
        List<Team> teams = new ArrayList<>();


        for(int id : ids) {
            teams.add(teamRepository.findByUserId(id));
        }

        int numberOfTeams = teams.size();
        Map<Integer, Team> randomMap = new HashMap<>();
        Random rand = new Random();

        // random number for each team
        for (int i = 1; i <= numberOfTeams; i++) {
            int randomIndex = rand.nextInt(teams.size());
            Team randomTeam = teams.get(randomIndex);
            teams.remove(randomIndex);
            randomMap.put(i, randomTeam);
        }

        for (int i = 1; i <= randomMap.size(); i++) {
            System.out.println("i = " + i + " - Team: " + randomMap.get(i).getName());
        }


        // set gamedays
        for (int gameday = 1; gameday <= numberOfTeams; gameday++) {

        }

        //gameday 1
        GameDay gameDay1 = new GameDay();
        gameDay1.setNumber(1);
        gameDay1.setDate(dates.get(0));

        Set<Team> teamSet = new HashSet<>();
        Set<Game> gameSet1 = new HashSet<>();

        Game game1 = new Game();
        Set<Team> teamSet1 = new HashSet<>();
        teamSet1.add(randomMap.get(1));
        teamSet1.add(randomMap.get(9));
        game1.setTeams(teamSet1);

        Game game2 = new Game();
        Set<Team> teamSet2 = new HashSet<>();
        teamSet2.add(randomMap.get(2));
        teamSet2.add(randomMap.get(8));
        game2.setTeams(teamSet2);

        Game game3 = new Game();
        Set<Team> teamSet3 = new HashSet<>();
        teamSet3.add(randomMap.get(3));
        teamSet3.add(randomMap.get(7));
        game3.setTeams(teamSet3);

        Game game4= new Game();
        Set<Team> teamSet4 = new HashSet<>();
        teamSet4.add(randomMap.get(4));
        teamSet4.add(randomMap.get(6));
        game4.setTeams(teamSet4);

        Game game5 = new Game();
        Set<Team> teamSet5 = new HashSet<>();
        teamSet5.add(randomMap.get(5));
        teamSet5.add(randomMap.get(10));
        game5.setTeams(teamSet5);

        gameSet1.add(game1);
        gameSet1.add(game2);
        gameSet1.add(game3);
        gameSet1.add(game4);
        gameSet1.add(game5);

        gameDay1.setGames(gameSet1);

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);
        gameRepository.save(game4);
        gameRepository.save(game5);
        gameDayRepository.save(gameDay1);



        System.out.println("Teams in first list: " + teams);
        System.out.println("Teams in Map: " + randomMap);
        System.out.println("GameDay1: " + gameDay1);

        Set<Game> games = gameDayRepository.findByNumber(1).getGames();
    }
}
