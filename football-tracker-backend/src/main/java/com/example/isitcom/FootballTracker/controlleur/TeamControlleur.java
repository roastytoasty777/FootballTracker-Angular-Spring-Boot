package com.example.isitcom.FootballTracker.controlleur;

import com.example.isitcom.FootballTracker.entities.Team;
import com.example.isitcom.FootballTracker.service.IServiceTeam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class TeamControlleur {

    private final IServiceTeam serviceTeam;

    @GetMapping("/teams/all")
    public String allTeams(Model m, @RequestParam(name = "mc", defaultValue = "") String mc) {
        List<Team> teams;

        if (mc.isEmpty()) {
            teams = serviceTeam.getAllTeams();
        } else {
            teams = serviceTeam.getTeamsByMC(mc);
        }

        m.addAttribute("teams", teams);
        m.addAttribute("mc", mc);

        return "teams/accueil";
    }

    @PostMapping("/teams/delete/{id}")
    public String deleteTeam(@PathVariable int id) {
        serviceTeam.deleteTeam(id);
        return "redirect:/teams/all";
    }

    @GetMapping("/teams/add")
    public String showAddForm(Model m) {
        m.addAttribute("team", new Team());
        return "teams/ajouterTeam";
    }

    @PostMapping("/teams/save")
    public String saveTeam(@ModelAttribute Team team) {
        serviceTeam.saveTeam(team);
        return "redirect:/teams/all";
    }

    @GetMapping("/teams/edit/{id}")
    public String showEditForm(@PathVariable int id, Model m) {
        Team t = serviceTeam.getTeamById(id);
        m.addAttribute("team", t);
        return "teams/modifierTeam";
    }
}