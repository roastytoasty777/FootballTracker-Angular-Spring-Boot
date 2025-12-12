package com.example.isitcom.FootballTracker.service;

import com.example.isitcom.FootballTracker.entities.Player;

import java.util.List;

public interface IServicePlayer {
    public String savePlayer(Player p);
    public Player getPlayerById(int id);
    public String deletePlayer(int id);
    public List<Player> getAllPlayers();
    public List<Player> getPlayerByMC(String mc);
}
