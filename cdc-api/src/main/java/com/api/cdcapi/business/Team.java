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
        this.team_id = UUID.randomUUID();
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

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public double getPlayersWeightMean() {
        return this.players.stream().collect(Collectors.averagingDouble(p -> p.getCategory().getHigher_value()));
    }

    public double getPlayersSeniorityMean() {
        return this.players.stream().collect(Collectors.averagingDouble(p -> p.getSeniority()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("======= ").append(this.team_id).append(" =======").append(System.getProperty("line.separator"))
                .append("Nombre de joueurs : ").append(this.players.size()).append(System.getProperty("line.separator"))
                .append("Moyenne poids : ").append(this.getPlayersWeightMean()).append(System.getProperty("line.separator"))
                .append("Moyenne anciennete : ").append(this.getPlayersSeniorityMean()).append(System.getProperty("line.separator"))
                .append("Liste des joueurs : ").append(System.getProperty("line.separator"));
        this.players.forEach(player -> sb.append("- ").append(player.toString()).append(System.getProperty("line.separator")));

        return sb.toString();
    }
}
