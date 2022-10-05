package com.example.league_manager_backend.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Team> teams;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Match> matches;

    public Game() {

    }

    public Game(Long id, Set<Team> teams, Set<Match> matches) {
        this.id = id;
        this.teams = teams;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id.equals(game.id) && Objects.equals(teams, game.teams) && Objects.equals(matches, game.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teams, matches);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", teams=" + teams +
                ", matches=" + matches +
                '}';
    }
}
