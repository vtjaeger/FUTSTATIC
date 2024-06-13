package com.br.futstatic.models;

import com.br.futstatic.dtos.post.NewMatch;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Team homeTeam;
    @ManyToOne
    private Team visitingTeam;
    private Boolean finished;
    private String scoreboard;
    @Enumerated(EnumType.STRING)
    private Stadium stadium;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(Team visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public String getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(String scoreboard) {
        this.scoreboard = scoreboard;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Match() {
    }

    public Match(NewMatch newMatch, Team homeTeam, Team visitingTeam) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        if(newMatch.scoreboard() == null) {
            this.scoreboard = "0-0";
        } else {
            this.scoreboard = newMatch.scoreboard();
        }
        this.stadium = newMatch.stadium();
        this.finished = false;
    }
}
