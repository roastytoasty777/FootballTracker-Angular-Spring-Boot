package com.example.isitcom.FootballTracker.service;

import com.example.isitcom.FootballTracker.entities.Team;
import java.util.List;

public interface IServiceTeam {
    public String saveTeam(Team t);
    public Team getTeamById(int id);
    public String deleteTeam(int id);
    public List<Team> getAllTeams();
    public List<Team> getTeamsByMC(String mc);
}