package com.api.cdcapi.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class Team {
    
    private UUID team_id;
    private Collection<Player> players = new ArrayList<>();

    public Team() {
    }

    public Team(Collection<Player> players) {
        this.team_id = UUID.randomUUID();
        this.players = players;
    }

    public UUID getTeam_id() {
        return team_id;
    }

    public void setTeam_id(UUID team_id) {
        this.team_id = team_id;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public double getPlayersWeightMean() {
        return this.players.stream().collect(Collectors.averagingDouble(p -> p.getCategory().getHigher_value()));
    }
}
