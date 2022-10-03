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

//        gameRepository.save(game1);
//        gameRepository.save(game2);
//        gameRepository.save(game3);
//        gameRepository.save(game4);
//        gameRepository.save(game5);
        gameDayRepository.save(gameDay1);


        // Gameday2
        GameDay gameDay2 = new GameDay();
        gameDay2.setNumber(2);
        gameDay2.setDate(dates.get(1));

        Set<Game> gameSet2 = new HashSet<>();

        Game game21 = new Game();
        Set<Team> teamSet21 = new HashSet<>();
        teamSet21.add(randomMap.get(10));
        teamSet21.add(randomMap.get(1));
        game21.setTeams(teamSet21);

        Game game22 = new Game();
        Set<Team> teamSet22 = new HashSet<>();
        teamSet22.add(randomMap.get(2));
        teamSet22.add(randomMap.get(9));
        game22.setTeams(teamSet22);

        Game game23 = new Game();
        Set<Team> teamSet23 = new HashSet<>();
        teamSet23.add(randomMap.get(3));
        teamSet23.add(randomMap.get(8));
        game23.setTeams(teamSet23);

        Game game24= new Game();
        Set<Team> teamSet24 = new HashSet<>();
        teamSet24.add(randomMap.get(4));
        teamSet24.add(randomMap.get(7));
        game24.setTeams(teamSet24);

        Game game25 = new Game();
        Set<Team> teamSet25 = new HashSet<>();
        teamSet25.add(randomMap.get(5));
        teamSet25.add(randomMap.get(6));
        game25.setTeams(teamSet25);

        gameSet2.add(game21);
        gameSet2.add(game22);
        gameSet2.add(game23);
        gameSet2.add(game24);
        gameSet2.add(game25);

        gameDay2.setGames(gameSet2);

//        gameRepository.save(game21);
//        gameRepository.save(game22);
//        gameRepository.save(game23);
//        gameRepository.save(game24);
//        gameRepository.save(game25);
        gameDayRepository.save(gameDay2);

        // Gameday3
        GameDay gameDay3 = new GameDay();
        gameDay3.setNumber(3);
        gameDay3.setDate(dates.get(2));

        Set<Game> gameSet3 = new HashSet<>();

        Game game31 = new Game();
        Set<Team> teamSet31 = new HashSet<>();
        teamSet31.add(randomMap.get(2));
        teamSet31.add(randomMap.get(1));
        game31.setTeams(teamSet31);

        Game game32 = new Game();
        Set<Team> teamSet32 = new HashSet<>();
        teamSet32.add(randomMap.get(3));
        teamSet32.add(randomMap.get(9));
        game32.setTeams(teamSet32);

        Game game33 = new Game();
        Set<Team> teamSet33 = new HashSet<>();
        teamSet33.add(randomMap.get(4));
        teamSet33.add(randomMap.get(8));
        game33.setTeams(teamSet33);

        Game game34= new Game();
        Set<Team> teamSet34 = new HashSet<>();
        teamSet34.add(randomMap.get(5));
        teamSet34.add(randomMap.get(7));
        game34.setTeams(teamSet34);

        Game game35 = new Game();
        Set<Team> teamSet35 = new HashSet<>();
        teamSet35.add(randomMap.get(6));
        teamSet35.add(randomMap.get(10));
        game35.setTeams(teamSet35);

        gameSet3.add(game31);
        gameSet3.add(game32);
        gameSet3.add(game33);
        gameSet3.add(game34);
        gameSet3.add(game35);

        gameDay3.setGames(gameSet3);

//        gameRepository.save(game31);
//        gameRepository.save(game32);
//        gameRepository.save(game33);
//        gameRepository.save(game34);
//        gameRepository.save(game35);
        gameDayRepository.save(gameDay3);
    }
}
