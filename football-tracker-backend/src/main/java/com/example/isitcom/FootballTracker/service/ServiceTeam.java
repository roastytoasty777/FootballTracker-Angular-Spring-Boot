package com.example.isitcom.FootballTracker.service;

import com.example.isitcom.FootballTracker.entities.Team;
import com.example.isitcom.FootballTracker.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceTeam implements IServiceTeam {

    private TeamRepository teamRepository;

    @Override
    public String saveTeam(Team t) {
        teamRepository.save(t);
        return null;
    }

    @Override
    public Team getTeamById(int id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public String deleteTeam(int id) {
        teamRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> getTeamsByMC(String mc) {
        return teamRepository.rechercherParMotCle(mc + "%");
    }
}