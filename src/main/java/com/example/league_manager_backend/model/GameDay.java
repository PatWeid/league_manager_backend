package com.example.league_manager_backend.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class GameDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private Date date;

    // TODO: check cascade and join column
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "tutorial_id")
//    @Size(max = 2)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Game> games;

    public GameDay() {

    }

    public GameDay(int number, Date date, Set<Game> games) {
        this.number = number;
        this.date = date;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDay gameDay = (GameDay) o;
        return number == gameDay.number && id.equals(gameDay.id) && date.equals(gameDay.date) && games.equals(gameDay.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, date, games);
    }

    @Override
    public String toString() {
        return "GameDay{" +
                "id=" + id +
                ", number=" + number +
                ", date=" + date +
                ", games=" + games +
                '}';
    }
}
