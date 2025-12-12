package com.example.isitcom.FootballTracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String ville;
    private int annee;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Player> players;

    @OneToMany(mappedBy = "homeTeam")
    @JsonIgnore
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "awayTeam")
    @JsonIgnore
    private List<Match> awayMatches;
}