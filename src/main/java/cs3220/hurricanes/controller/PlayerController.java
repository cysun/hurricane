package cs3220.hurricanes.controller;

import cs3220.hurricanes.model.Player;
import cs3220.hurricanes.repository.PlayerRepository;
import cs3220.hurricanes.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerController(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "player/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        var currentYear = Year.now().getValue();
        int[] years = IntStream.range(currentYear - 12, currentYear - 3).toArray();
        model.addAttribute("years", years);
        return "player/add";
    }

    @PostMapping("/add")
    public String add(Player player) {
        playerRepository.save(player);
        return "redirect:/players";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        var player = playerRepository.findById(id).orElse(null);
        if (player == null) return "redirect:/players";

        var currentYear = Year.now().getValue();
        int[] years = IntStream.range(currentYear - 12, currentYear - 3).toArray();
        var teams = teamRepository.findTeamsForPlayer(player.getGender(), player.getAge());

        model.addAttribute("player", player);
        model.addAttribute("years", years);
        model.addAttribute("teams", teams);

        return "player/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, Player newPlayer, Integer teamId) {
        var player = playerRepository.findById(id).orElse(null);
        if (player == null) return "redirect:/players";

        player.setName(newPlayer.getName());
        player.setGender(newPlayer.getGender());
        player.setBirthYear(newPlayer.getBirthYear());

        if (teamId == null) player.setTeam(null);
        else {
            player.setTeam(teamRepository.findById(teamId).orElse(null));
        }

        playerRepository.save(player);
        return "redirect:/players";
    }
}
