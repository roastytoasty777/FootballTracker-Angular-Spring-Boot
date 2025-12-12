package com.example.isitcom.FootballTracker.controlleur;

import com.example.isitcom.FootballTracker.entities.Match;
import com.example.isitcom.FootballTracker.service.IServiceMatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/matchs")
public class MatchRestControlleur {

    private final IServiceMatch serviceMatch;

    @GetMapping
    public List<Match> getAllMatches(@RequestParam(name = "mc", required = false) String mc) {
        if (mc != null && !mc.isEmpty()) {
            return serviceMatch.getMatchsByMC(mc);
        }
        return serviceMatch.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable int id) {
        return serviceMatch.getMatchById(id);
    }

    @PostMapping
    public ResponseEntity<Match> saveMatch(@RequestBody Match match) {
        serviceMatch.saveMatch(match);
        return new ResponseEntity<>(match, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
        serviceMatch.saveMatch(match);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int id) {
        serviceMatch.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}