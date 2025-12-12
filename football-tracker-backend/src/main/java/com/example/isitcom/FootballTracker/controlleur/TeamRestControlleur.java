package com.example.isitcom.FootballTracker.controlleur;

import com.example.isitcom.FootballTracker.entities.Team;
import com.example.isitcom.FootballTracker.service.IServiceTeam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teams")
public class TeamRestControlleur {

    private final IServiceTeam serviceTeam;

    @GetMapping
    public List<Team> allTeams(@RequestParam(name = "mc", required = false) String mc) {
        if (mc != null && !mc.isEmpty()) {
            return serviceTeam.getTeamsByMC(mc);
        }
        return serviceTeam.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable int id) {
        return serviceTeam.getTeamById(id);
    }

    @PostMapping
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        serviceTeam.saveTeam(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        serviceTeam.saveTeam(team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        serviceTeam.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}