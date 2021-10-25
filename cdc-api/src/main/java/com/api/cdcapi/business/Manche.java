package com.api.cdcapi.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

public class Manche {

    private UUID manche_id;
    private List<Team> teams = new ArrayList<>();
    private Integer mancheNumber;
    
    public Manche(List<Team> teams, Integer mancheNumber){
        this.manche_id = UUID.randomUUID();
        this.teams = teams;
        this.mancheNumber = mancheNumber;
    }
    

    public UUID getManche_id() {
        return this.manche_id;
    }

    public void setManche_id(UUID manche_id) {
        this.manche_id = manche_id;
    }

    public List<Team> getMancheTeams(){
        return this.teams;    
    }

    public void setMancheTeams(List<Team> newTeams){
        this.teams = newTeams;      
    }

    public Integer getMancheNumber(){
        return this.mancheNumber;
    }

    public void setMancheNumber(Integer mancheNumber){
        this.mancheNumber = mancheNumber;
    }

    public Integer getTotalNumberOfPlayers(){
        int numberOfPlayer = 0;
        for (Team team : teams){
            numberOfPlayer += team.getPlayers().size();
        }
        return numberOfPlayer;
    }



}
