package com.example.isitcom.FootballTracker.service;

import com.example.isitcom.FootballTracker.entities.Match;
import com.example.isitcom.FootballTracker.repository.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceMatch implements IServiceMatch {

    private MatchRepository matchRepository;

    @Override
    public String saveMatch(Match m) {
        matchRepository.save(m);
        return null;
    }

    @Override
    public Match getMatchById(int id) {
        return matchRepository.findById(id).get();
    }

    @Override
    public String deleteMatch(int id) {
        matchRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getMatchsByMC(String mc) {
        return matchRepository.rechercherParMotCle(mc + "%");
    }
}