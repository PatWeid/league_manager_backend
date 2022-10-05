package com.example.league_manager_backend.security.services;

import com.example.league_manager_backend.model.Match;
import com.example.league_manager_backend.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The matches are created by the following schema:
 * <a href="https://de.wikipedia.org/wiki/Turniersystem_(Tischtennis)#Paarkreuzsystem_ab_den_1990er_Jahren">...</a>
 */
@Service
public class MatchCreator {
    public static Set<Match> createMatches(Set<Team> teamSet) {
        Set<Match> matchSet = new HashSet<>();
        List<Team> teams = new ArrayList<>(teamSet);
        Team team1 = teams.get(0);
        Team team2 = teams.get(1);

        Match match1 = new Match(1, team1.getDouble1(), team2.getDouble2());
        Match match2 = new Match(2, team1.getDouble2(), team2.getDouble1());
        Match match3 = new Match(3, team1.getDouble3(), team2.getDouble3());
        Match match4 = new Match(4, team1.getPlayer1(), team2.getPlayer2());
        Match match5 = new Match(5, team1.getPlayer2(), team2.getPlayer1());
        Match match6 = new Match(6, team1.getPlayer3(), team2.getPlayer4());
        Match match7 = new Match(7, team1.getPlayer4(), team2.getPlayer3());
        Match match8 = new Match(8, team1.getPlayer5(), team2.getPlayer6());
        Match match9 = new Match(9, team1.getPlayer6(), team2.getPlayer5());
        Match match10 = new Match(10, team1.getPlayer1(), team2.getPlayer1());
        Match match11 = new Match(11, team1.getPlayer2(), team2.getPlayer2());
        Match match12 = new Match(12, team1.getPlayer3(), team2.getPlayer3());
        Match match13 = new Match(13, team1.getPlayer4(), team2.getPlayer4());
        Match match14 = new Match(14, team1.getPlayer5(), team2.getPlayer5());
        Match match15 = new Match(15, team1.getPlayer6(), team2.getPlayer6());
        Match match16 = new Match(16, team1.getDouble1(), team2.getDouble2());

        matchSet.add(match1);
        matchSet.add(match2);
        matchSet.add(match3);
        matchSet.add(match4);
        matchSet.add(match5);
        matchSet.add(match6);
        matchSet.add(match7);
        matchSet.add(match8);
        matchSet.add(match9);
        matchSet.add(match10);
        matchSet.add(match11);
        matchSet.add(match12);
        matchSet.add(match13);
        matchSet.add(match14);
        matchSet.add(match15);
        matchSet.add(match16);

        return matchSet;
    }
}
