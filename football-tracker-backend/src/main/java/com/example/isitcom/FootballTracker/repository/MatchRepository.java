package com.example.isitcom.FootballTracker.repository;

import com.example.isitcom.FootballTracker.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
//    @Query("SELECT m FROM Match m JOIN FETCH m.homeTeam JOIN FETCH m.awayTeam")
//    List<Match> findAllWithTeams();
    @Query("select m from Match m where m.venue like :x")
    public List<Match> rechercherParMotCle(@Param("x") String mc);
}