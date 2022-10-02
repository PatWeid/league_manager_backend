package com.example.league_manager_backend.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 120)
    private String double1;

    @NotBlank
    @Size(max = 120)
    private String double2;

    @NotBlank
    @Size(max = 120)
    private String double3;

    @NotBlank
    @Size(max = 50)
    private String player1;

    @NotBlank
    @Size(max = 50)
    private String player2;

    @NotBlank
    @Size(max = 50)
    private String player3;

    @NotBlank
    @Size(max = 50)
    private String player4;

    @NotBlank
    @Size(max = 50)
    private String player5;

    @NotBlank
    @Size(max = 50)
    private String player6;

    public Team() {

    }

    public Team(User user, String name, String double1, String double2, String double3, String player1, String player2, String player3, String player4, String player5, String player6) {
        this.user = user;
        this.name = name;
        this.double1 = double1;
        this.double2 = double2;
        this.double3 = double3;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDouble1() {
        return double1;
    }

    public void setDouble1(String double1) {
        this.double1 = double1;
    }

    public String getDouble2() {
        return double2;
    }

    public void setDouble2(String double2) {
        this.double2 = double2;
    }

    public String getDouble3() {
        return double3;
    }

    public void setDouble3(String double3) {
        this.double3 = double3;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public String getPlayer6() {
        return player6;
    }

    public void setPlayer6(String player6) {
        this.player6 = player6;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", double1='" + double1 + '\'' +
                ", double2='" + double2 + '\'' +
                ", double3='" + double3 + '\'' +
                ", player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", player3='" + player3 + '\'' +
                ", player4='" + player4 + '\'' +
                ", player5='" + player5 + '\'' +
                ", player6='" + player6 + '\'' +
                '}';
    }


}
