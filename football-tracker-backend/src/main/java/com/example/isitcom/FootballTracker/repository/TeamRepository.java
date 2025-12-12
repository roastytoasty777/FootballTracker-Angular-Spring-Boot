package com.example.isitcom.FootballTracker.repository;

import com.example.isitcom.FootballTracker.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query("select t from Team t where t.nom like :x")
    public List<Team> rechercherParMotCle(@Param("x")   String mc);
}
