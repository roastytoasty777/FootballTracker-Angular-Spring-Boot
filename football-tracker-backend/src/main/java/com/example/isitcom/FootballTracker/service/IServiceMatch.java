package com.example.isitcom.FootballTracker.service;

import com.example.isitcom.FootballTracker.entities.Match;
import java.util.List;

public interface IServiceMatch {
    public String saveMatch(Match m);
    public Match getMatchById(int id);
    public String deleteMatch(int id);
    public List<Match> getAllMatches();
    public List<Match> getMatchsByMC(String mc);
}