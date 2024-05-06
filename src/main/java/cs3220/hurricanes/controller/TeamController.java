package cs3220.hurricanes.controller;

import cs3220.hurricanes.model.Team;
import cs3220.hurricanes.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teams")
public class TeamController {
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "team/index";
    }

    @GetMapping("/add")
    public String add() {
        return "team/add";
    }

    @PostMapping("/add")
    public String add(Team team) {
        teamRepository.save(team);
        return "redirect:/teams";
    }

    @GetMapping("/{id}/roster")
    public String roster(@PathVariable int id, Model model) {
        var team = teamRepository.findById(id).orElse(null);
        if (team == null) return "redirect:/teams";

        model.addAttribute("team", team);
        return "team/roster";
    }
}
