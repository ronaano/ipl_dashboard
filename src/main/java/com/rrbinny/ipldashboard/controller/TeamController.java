package com.rrbinny.ipldashboard.controller;

import com.rrbinny.ipldashboard.model.Match;
import com.rrbinny.ipldashboard.model.Team;
import com.rrbinny.ipldashboard.repository.MatchRepository;
import com.rrbinny.ipldashboard.repository.TeamRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }

    @GetMapping("/teams/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
      Team team = this.teamRepository.findByTeamName(teamName);
      team.setMatches(this.matchRepository.findLatestMatchesbyTeam(teamName,4));
      return team;
    }

    @GetMapping("/teams/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year)
    {
        LocalDate startDate = LocalDate.of(year,1,1);
        LocalDate endDate = LocalDate.of(year + 1,1,1);
        return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate,endDate);
    }


}
