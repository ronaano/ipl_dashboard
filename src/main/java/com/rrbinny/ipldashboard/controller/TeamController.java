package com.rrbinny.ipldashboard.controller;

import com.rrbinny.ipldashboard.model.Team;
import com.rrbinny.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
       return this.teamRepository.findByTeamName(teamName);
    }
}
