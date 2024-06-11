package com.br.futstatic.models;

import com.br.futstatic.dtos.post.NewTeam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Countries country;
    @OneToMany(mappedBy = "currentTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Player> players;
    private List<String> awards;
    private int yearFoundation;

    public Team(NewTeam newTeam) {
        this.name = newTeam.name();
        this.country = newTeam.country();
        this.players = newTeam.players();
        this.yearFoundation = newTeam.yearFoundation();
        if (newTeam.awards() != null) {
            this.awards = new ArrayList<>(newTeam.awards());
        } else {
            this.awards = new ArrayList<>();
        }
    }

    public Team() {
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

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public int getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(int yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

    public Team(Long id, String name, Countries country, List<Player> players, int yearFoundation) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.players = players;
        this.yearFoundation = yearFoundation;
    }

}
