package com.api.cdcapi.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

public class Session {

    private UUID session_id;
    private List<Manche> manches = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Integer currentManche;
    
    
    public Session(List<Manche> manches, List<Player> players, Integer currentManche){
        this.session_id = UUID.randomUUID();
        this.manches = manches;
        this.players = players;
        this.currentManche = currentManche;
    }
    public Session(List<Manche> manches, List<Player> players){
        this(manches, players, 1);
    }
    

    public UUID getSession_id() {
        return this.session_id;
    }

    public void setSession_id(UUID session_id) {
        this.session_id = session_id;
    }

    public List<Manche> getSessionManches(){
        return this.manches;    
    }

    public void setSessionManches(List<Manche> newManches){
        this.manches = newManches;      
    }

    public List<Player> getSessionPlayers(){
        return this.players;    
    }

    public void addNewPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }

    public void updatePlayer(Player player, Armor armortype){
        if (player.getArmor() != armortype){
            player.setArmor(armortype);
        }
    }

    public void setSessionPlayers(List<Player> newPlayers){
        this.players = newPlayers;      
    }

    public Manche getCurrentManche(){
        return this.getSessionManches().get(this.currentManche-1);
    }

    public void nextManche(){
        if (this.currentManche < this.getSessionManches().size()){
            this.currentManche+=1;
        }
    }
    
}
