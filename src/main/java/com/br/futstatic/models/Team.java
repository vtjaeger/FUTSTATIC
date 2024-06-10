package com.br.futstatic.models;

import com.br.futstatic.dtos.NewTeam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
    private String awards;

    public Team(NewTeam newTeam) {
        this.name = newTeam.name();
        this.country = newTeam.country();
        this.players = newTeam.players();
        if(newTeam.awards() != null) {
            this.awards = newTeam.awards();
        } else {
            this.awards = null;
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

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public Team(Long id, String name, Countries country, List<Player> players) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.players = players;
    }

}
