package com.api.cdcapi.services;

import com.api.cdcapi.business.Player;
import com.api.cdcapi.business.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    public void createTeams(Team team1, Team team2, List<Player> players) {
        int index = 0;
        for (Player player : players) {
            if (index % 2 == 0) {
                team1.getPlayers().add(player);
            } else {
                team2.getPlayers().add(player);
            }
            index++;
        }
    }

}
