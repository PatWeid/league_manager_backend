package com.example.league_manager_backend.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Team> teams;

    public Game() {

    }

    public Game(Long id, Set<Team> teams) {
        this.id = id;
        this.teams = teams;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id.equals(game.id) && teams.equals(game.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teams);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", teams=" + teams +
                '}';
    }
}
