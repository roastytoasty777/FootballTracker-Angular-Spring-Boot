package com.example.isitcom.FootballTracker.repository;

import com.example.isitcom.FootballTracker.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("select p from Player p where p.nom like :x")
    public List<Player> rechercherParMotCle(@Param("x")  String mc);

}