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

        //TODO delete
        for (int i = 1; i <= randomMap.size(); i++) {
            System.out.println("i = " + i + " - Team: " + randomMap.get(i).getName());
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

        gameDayRepository.save(gameDay3);

        // Gameday4
        GameDay gameDay4 = new GameDay();
        gameDay4.setNumber(4);
        gameDay4.setDate(dates.get(3));

        Set<Game> gameSet4 = new HashSet<>();

        Game game41 = new Game();
        Set<Team> teamSet41 = new HashSet<>();
        teamSet41.add(randomMap.get(2));
        teamSet41.add(randomMap.get(10));
        game41.setTeams(teamSet41);

        Game game42 = new Game();
        Set<Team> teamSet42 = new HashSet<>();
        teamSet42.add(randomMap.get(3));
        teamSet42.add(randomMap.get(1));
        game42.setTeams(teamSet42);

        Game game43 = new Game();
        Set<Team> teamSet43 = new HashSet<>();
        teamSet43.add(randomMap.get(4));
        teamSet43.add(randomMap.get(9));
        game43.setTeams(teamSet43);

        Game game44= new Game();
        Set<Team> teamSet44 = new HashSet<>();
        teamSet44.add(randomMap.get(5));
        teamSet44.add(randomMap.get(8));
        game44.setTeams(teamSet44);

        Game game45 = new Game();
        Set<Team> teamSet45 = new HashSet<>();
        teamSet45.add(randomMap.get(6));
        teamSet45.add(randomMap.get(7));
        game45.setTeams(teamSet45);

        gameSet4.add(game41);
        gameSet4.add(game42);
        gameSet4.add(game43);
        gameSet4.add(game44);
        gameSet4.add(game45);

        gameDay4.setGames(gameSet4);

        gameDayRepository.save(gameDay4);

        // Gameday5
        GameDay gameDay5 = new GameDay();
        gameDay5.setNumber(5);
        gameDay5.setDate(dates.get(4));

        Set<Game> gameSet5 = new HashSet<>();

        Game game51 = new Game();
        Set<Team> teamSet51 = new HashSet<>();
        teamSet51.add(randomMap.get(2));
        teamSet51.add(randomMap.get(3));
        game51.setTeams(teamSet51);

        Game game52 = new Game();
        Set<Team> teamSet52 = new HashSet<>();
        teamSet52.add(randomMap.get(4));
        teamSet52.add(randomMap.get(1));
        game52.setTeams(teamSet52);

        Game game53 = new Game();
        Set<Team> teamSet53 = new HashSet<>();
        teamSet53.add(randomMap.get(5));
        teamSet53.add(randomMap.get(9));
        game53.setTeams(teamSet53);

        Game game54= new Game();
        Set<Team> teamSet54 = new HashSet<>();
        teamSet54.add(randomMap.get(6));
        teamSet54.add(randomMap.get(8));
        game54.setTeams(teamSet54);

        Game game55 = new Game();
        Set<Team> teamSet55 = new HashSet<>();
        teamSet55.add(randomMap.get(7));
        teamSet55.add(randomMap.get(10));
        game55.setTeams(teamSet55);

        gameSet5.add(game51);
        gameSet5.add(game52);
        gameSet5.add(game53);
        gameSet5.add(game54);
        gameSet5.add(game55);

        gameDay5.setGames(gameSet5);

        gameDayRepository.save(gameDay5);

        // Gameday6
        GameDay gameDay6 = new GameDay();
        gameDay6.setNumber(6);
        gameDay6.setDate(dates.get(5));

        Set<Game> gameSet6 = new HashSet<>();

        Game game61 = new Game();
        Set<Team> teamSet61 = new HashSet<>();
        teamSet61.add(randomMap.get(10));
        teamSet61.add(randomMap.get(3));
        game61.setTeams(teamSet61);

        Game game62 = new Game();
        Set<Team> teamSet62 = new HashSet<>();
        teamSet62.add(randomMap.get(4));
        teamSet62.add(randomMap.get(2));
        game62.setTeams(teamSet62);

        Game game63 = new Game();
        Set<Team> teamSet63 = new HashSet<>();
        teamSet63.add(randomMap.get(5));
        teamSet63.add(randomMap.get(1));
        game63.setTeams(teamSet63);

        Game game64= new Game();
        Set<Team> teamSet64 = new HashSet<>();
        teamSet64.add(randomMap.get(6));
        teamSet64.add(randomMap.get(9));
        game64.setTeams(teamSet64);

        Game game65 = new Game();
        Set<Team> teamSet65 = new HashSet<>();
        teamSet65.add(randomMap.get(7));
        teamSet65.add(randomMap.get(8));
        game65.setTeams(teamSet65);

        gameSet6.add(game61);
        gameSet6.add(game62);
        gameSet6.add(game63);
        gameSet6.add(game64);
        gameSet6.add(game65);

        gameDay6.setGames(gameSet6);

        gameDayRepository.save(gameDay6);

        // Gameday7
        GameDay gameDay7 = new GameDay();
        gameDay7.setNumber(7);
        gameDay7.setDate(dates.get(6));

        Set<Game> gameSet7 = new HashSet<>();

        Game game71 = new Game();
        Set<Team> teamSet71 = new HashSet<>();
        teamSet71.add(randomMap.get(4));
        teamSet71.add(randomMap.get(3));
        game71.setTeams(teamSet71);

        Game game72 = new Game();
        Set<Team> teamSet72 = new HashSet<>();
        teamSet72.add(randomMap.get(5));
        teamSet72.add(randomMap.get(2));
        game72.setTeams(teamSet72);

        Game game73 = new Game();
        Set<Team> teamSet73 = new HashSet<>();
        teamSet73.add(randomMap.get(6));
        teamSet73.add(randomMap.get(1));
        game73.setTeams(teamSet73);

        Game game74= new Game();
        Set<Team> teamSet74 = new HashSet<>();
        teamSet74.add(randomMap.get(7));
        teamSet74.add(randomMap.get(9));
        game74.setTeams(teamSet74);

        Game game75 = new Game();
        Set<Team> teamSet75 = new HashSet<>();
        teamSet75.add(randomMap.get(10));
        teamSet75.add(randomMap.get(8));
        game75.setTeams(teamSet75);

        gameSet7.add(game71);
        gameSet7.add(game72);
        gameSet7.add(game73);
        gameSet7.add(game74);
        gameSet7.add(game75);

        gameDay7.setGames(gameSet7);

        gameDayRepository.save(gameDay7);

        // Gameday8
        GameDay gameDay8 = new GameDay();
        gameDay8.setNumber(8);
        gameDay8.setDate(dates.get(7));

        Set<Game> gameSet8 = new HashSet<>();

        Game game81 = new Game();
        Set<Team> teamSet81 = new HashSet<>();
        teamSet81.add(randomMap.get(4));
        teamSet81.add(randomMap.get(10));
        game81.setTeams(teamSet81);

        Game game82 = new Game();
        Set<Team> teamSet82 = new HashSet<>();
        teamSet82.add(randomMap.get(5));
        teamSet82.add(randomMap.get(3));
        game82.setTeams(teamSet82);

        Game game83 = new Game();
        Set<Team> teamSet83 = new HashSet<>();
        teamSet83.add(randomMap.get(6));
        teamSet83.add(randomMap.get(2));
        game83.setTeams(teamSet83);

        Game game84= new Game();
        Set<Team> teamSet84 = new HashSet<>();
        teamSet84.add(randomMap.get(7));
        teamSet84.add(randomMap.get(1));
        game84.setTeams(teamSet84);

        Game game85 = new Game();
        Set<Team> teamSet85 = new HashSet<>();
        teamSet85.add(randomMap.get(9));
        teamSet85.add(randomMap.get(8));
        game85.setTeams(teamSet85);

        gameSet8.add(game81);
        gameSet8.add(game82);
        gameSet8.add(game83);
        gameSet8.add(game84);
        gameSet8.add(game85);

        gameDay8.setGames(gameSet8);

        gameDayRepository.save(gameDay8);

        // Gameday9
        GameDay gameDay9 = new GameDay();
        gameDay9.setNumber(9);
        gameDay9.setDate(dates.get(8));

        Set<Game> gameSet9 = new HashSet<>();

        Game game91 = new Game();
        Set<Team> teamSet91 = new HashSet<>();
        teamSet91.add(randomMap.get(4));
        teamSet91.add(randomMap.get(5));
        game91.setTeams(teamSet91);

        Game game92 = new Game();
        Set<Team> teamSet92 = new HashSet<>();
        teamSet92.add(randomMap.get(6));
        teamSet92.add(randomMap.get(3));
        game92.setTeams(teamSet92);

        Game game93 = new Game();
        Set<Team> teamSet93 = new HashSet<>();
        teamSet93.add(randomMap.get(7));
        teamSet93.add(randomMap.get(2));
        game93.setTeams(teamSet93);

        Game game94= new Game();
        Set<Team> teamSet94 = new HashSet<>();
        teamSet94.add(randomMap.get(8));
        teamSet94.add(randomMap.get(1));
        game94.setTeams(teamSet94);

        Game game95 = new Game();
        Set<Team> teamSet95 = new HashSet<>();
        teamSet95.add(randomMap.get(9));
        teamSet95.add(randomMap.get(10));
        game95.setTeams(teamSet95);

        gameSet9.add(game91);
        gameSet9.add(game92);
        gameSet9.add(game93);
        gameSet9.add(game94);
        gameSet9.add(game95);

        gameDay9.setGames(gameSet9);

        gameDayRepository.save(gameDay9);
    }
}
