package com.example.isitcom.FootballTracker.controlleur;


import com.example.isitcom.FootballTracker.entities.Player;
import com.example.isitcom.FootballTracker.entities.Team;
import com.example.isitcom.FootballTracker.service.IServiceTeam;
import com.example.isitcom.FootballTracker.service.ServicePlayer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerControlleur {
    private ServicePlayer servicePlayer;
    private IServiceTeam serviceTeam;

    @GetMapping("/players/all")
    public String all(Model m, @RequestParam(name = "mc", defaultValue = "") String mc) {
        List<Player> players;

        if (mc.isEmpty()) {
            players = servicePlayer.getAllPlayers();
        } else {
            players = servicePlayer.getPlayerByMC(mc);
        }

        m.addAttribute("players", players);
        m.addAttribute("mc", mc);

        return "players/accueil";
    }

    @PostMapping("/players/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        servicePlayer.deletePlayer(id);
        return "redirect:/players/all";
    }

    @GetMapping("/players/add")
    public String showAddForm(Model m) {
        m.addAttribute("player", new Player());
        m.addAttribute("teams", serviceTeam.getAllTeams());

        return "players/ajouterPlayer";
    }

    @PostMapping("/players/save")
    public String savePlayer(@ModelAttribute Player player) {
        servicePlayer.savePlayer(player);
        return "redirect:/players/all";
    }

    @GetMapping("/players/edit/{id}")
    public String showEditForm(@PathVariable int id, Model m) {
        Player p = servicePlayer.getPlayerById(id);
        m.addAttribute("player", p);
        m.addAttribute("teams", serviceTeam.getAllTeams());
        return "players/modifierPlayer";
    }
}