package com.br.futstatic.models;

import com.br.futstatic.dtos.post.NewPlayer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private Positions position;
    private int number;
    @OneToMany
    private List<Team> latestTeams;
    private Boolean retired;

    public Player(NewPlayer newPlayer, Team team) {
        this.name = newPlayer.name();
        this.age = newPlayer.age();
        if(newPlayer.currentTeam() != null) {
            this.currentTeam = team;
            this.number = newPlayer.number();
        } else {
            this.currentTeam = null;
            this.number = Integer.parseInt(null);
        }
        this.position = newPlayer.position();
        this.retired = false;
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

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Boolean getRetired() {
        return retired;
    }

    public void setRetired(Boolean retired) {
        this.retired = retired;
    }

    public List<Team> getLatestTeams() {
        return latestTeams;
    }

    public void setLatestTeams(List<Team> latestTeams) {
        this.latestTeams = latestTeams;
    }

    public void updateRetired(){
        this.retired = !this.retired;
        // if(!this.retired) {
        //            this.retired = true;
        //        } else {
        //            this.retired = false;
        //        }
    }
}
