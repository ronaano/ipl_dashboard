package com.rrbinny.ipldashboard.controller;

import com.rrbinny.ipldashboard.model.Team;
import com.rrbinny.ipldashboard.repository.MatchRepository;
import com.rrbinny.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
      Team team = this.teamRepository.findByTeamName(teamName);
      team.setMatches(this.matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName,teamName));
      return team;
    }
}
