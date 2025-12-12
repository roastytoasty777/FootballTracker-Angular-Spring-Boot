package com.example.isitcom.FootballTracker.service;

import com.example.isitcom.FootballTracker.entities.Player;
import com.example.isitcom.FootballTracker.repository.PlayerRepository;
import com.example.isitcom.FootballTracker.service.IServiceTeam;
import com.example.isitcom.FootballTracker.entities.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ServicePlayer implements IServicePlayer{

    private PlayerRepository playerRepository;
    private IServiceTeam serviceTeam;

    @Override
    public String savePlayer(Player p) {
        playerRepository.save(p);
        return null;
    }

    @Override
    public Player getPlayerById(int id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public String deletePlayer(int id) {
        playerRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getPlayerByMC(String mc) {
        return playerRepository.rechercherParMotCle(mc + "%");
    }
}
