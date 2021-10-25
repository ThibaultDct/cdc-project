package com.api.cdcapi.services;

import com.api.cdcapi.business.Category;
import com.api.cdcapi.business.Player;
import com.api.cdcapi.business.Team;
import org.springframework.stereotype.Service;

import java.io.OptionalDataException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {

    public void createTeams(Team team1, Team team2, List<Player> players) throws IllegalArgumentException {
        Comparator<Player> sorting = Comparator.comparing(Player::getAverageWeight).thenComparing(Player::getSeniority);
        Player toPlace;

        while (!players.isEmpty()) {
            players.sort(sorting);
            toPlace = players.get(0);
            if (team1.getPlayers().size() <= team2.getPlayers().size()) {
                team1.addPlayer(players.get(0));
            } else {
                team2.addPlayer(players.get(0));
            }
            players.remove(toPlace);
        }
        System.out.println(team1.toString());
        System.out.println(team2.toString());
    }

}
