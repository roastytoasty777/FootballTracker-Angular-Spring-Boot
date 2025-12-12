package com.example.isitcom.FootballTracker.controlleur;

import com.example.isitcom.FootballTracker.entities.Player;
import com.example.isitcom.FootballTracker.service.ServicePlayer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/players")
public class PlayerRestControlleur {

    private ServicePlayer servicePlayer;

    @GetMapping
    public List<Player> allPlayers(@RequestParam(name = "mc", required = false) String mc) {
        if (mc != null && !mc.isEmpty()) {
            return servicePlayer.getPlayerByMC(mc);
        }
        return servicePlayer.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return servicePlayer.getPlayerById(id);
    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        servicePlayer.savePlayer(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        servicePlayer.savePlayer(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        servicePlayer.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}