package com.api.cdcapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.api.cdcapi.business.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;

@Service
public class SessionService {

    public Session createSession(Integer manchesNumber, List<Player> players){
        
        MancheService ms = new MancheService();
        
        Team team1 = new Team();
        Team team2 = new Team();
        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        List<Manche> manches = ms.createManches(manchesNumber, teams);

        return new Session(manches, players);
    }

    public void addPlayersToCurrentManche(Session session){

        TeamService ts = new TeamService();

        List<Team> teams = session.getCurrentManche().getMancheTeams();

        ts.createTeams(teams.get(0), teams.get(1), session.getSessionPlayers());

        session.getCurrentManche().setMancheTeams(teams);

    }

    public void playCurrentSessionManche(Session session){
        session.nextManche();        
    }
}
