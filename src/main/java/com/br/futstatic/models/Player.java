package com.br.futstatic.models;

import com.br.futstatic.dtos.NewPlayer;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team currentTeam;

    public Player(NewPlayer newPlayer, Team team) {
        this.name = newPlayer.name();
        this.age = newPlayer.age();
        this.currentTeam = team;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }
}
