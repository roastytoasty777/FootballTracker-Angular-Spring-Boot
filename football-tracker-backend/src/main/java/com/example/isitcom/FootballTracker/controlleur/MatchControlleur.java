package com.example.isitcom.FootballTracker.controlleur;

import com.example.isitcom.FootballTracker.entities.Match;
import com.example.isitcom.FootballTracker.service.IServiceMatch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class MatchControlleur {

    private IServiceMatch serviceMatch;

    @GetMapping("/matchs/all")
    public String allMatches(Model m, @RequestParam(name = "mc", defaultValue = "") String mc) {
        List<Match> matchs;

        if (mc.isEmpty()) {
            matchs = serviceMatch.getAllMatches();
        } else {
            matchs = serviceMatch.getMatchsByMC(mc);
        }

        m.addAttribute("matchs", matchs);
        m.addAttribute("mc", mc);
        return "matchs/accueil";
    }

    @PostMapping("/matchs/delete/{id}")
    public String deleteMatch(@PathVariable int id) {
        serviceMatch.deleteMatch(id);
        return "redirect:/matchs/all";
    }

    @GetMapping("/matchs/add")
    public String showAddForm(Model m) {
        m.addAttribute("match", new Match());
        return "matchs/ajouterMatch";
    }

    @PostMapping("/matchs/save")
    public String saveMatch(@ModelAttribute Match match) {
        serviceMatch.saveMatch(match);
        return "redirect:/matchs/all";
    }

    @GetMapping("/matchs/edit/{id}")
    public String showEditForm(@PathVariable int id, Model m) {
        Match ma = serviceMatch.getMatchById(id);
        m.addAttribute("match", ma);
        return "matchs/modifierMatch";
    }
}