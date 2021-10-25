package com.api.cdcapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.api.cdcapi.business.*;
import com.api.cdcapi.business.enums.ArmorType;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SessionServiceTest {

    @Autowired
    SessionService sessionService;

    @Test
    void check_default_session_current_manche_is_1(){
        
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));
        
        Session session = sessionService.createSession(5, players);

        Assertions.assertEquals(1, session.getCurrentManche().getMancheNumber());
    }
    @Test
    void check_session_manches_and_players_are_not_null(){
        
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));
        
        Session session = sessionService.createSession(5, players);

        Assertions.assertNotNull(session.getSessionManches());
        Assertions.assertNotNull(session.getSessionPlayers());

    }

    @Test
    void check_number_of_players(){


        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));
        
        Session session = sessionService.createSession(5, players);
        sessionService.addPlayersToCurrentManche(session);

        Assertions.assertEquals(4, session.getCurrentManche().getTotalNumberOfPlayers());
    }
    @Test
    void check_add_or_remove_player_are_taken_into_account_at_next_manche(){
        
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));
        
        Session session = sessionService.createSession(5, players);

        sessionService.addPlayersToCurrentManche(session);

        Player p1 = (new Player("SLT", "Alekandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.MAILLES), 50, 20, true));
        Player p2 = (new Player("MOR", "ban", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.PLAQUES), 60, 20, true));

        session.addNewPlayer(p1);
        session.addNewPlayer(p2);

        Assertions.assertEquals(4,session.getCurrentManche().getTotalNumberOfPlayers());

        sessionService.playCurrentSessionManche(session);
        sessionService.addPlayersToCurrentManche(session);

        session.removePlayer(p1);
        
        Assertions.assertEquals(6,session.getCurrentManche().getTotalNumberOfPlayers());

        sessionService.playCurrentSessionManche(session);
        sessionService.addPlayersToCurrentManche(session);
        
        Assertions.assertEquals(5,session.getCurrentManche().getTotalNumberOfPlayers());
    }
    
    @Test
    void check_session_current_manches_is_still_last_when_all_manche_are_played(){
        
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));
        
        Session session = sessionService.createSession(2, players);

        sessionService.addPlayersToCurrentManche(session);
        Assertions.assertNotEquals(2,session.getCurrentManche().getMancheNumber());
        

        sessionService.playCurrentSessionManche(session);
        Assertions.assertEquals(2,session.getCurrentManche().getMancheNumber());
        sessionService.playCurrentSessionManche(session);
        Assertions.assertEquals(2,session.getCurrentManche().getMancheNumber());
        
    }
        
    @Test
    void updateplayerinchange(){

        List<Player> players = new ArrayList<>();
        Player p1 = new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true);
        players.add(p1);
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));



        Session session = sessionService.createSession(5, players);
        sessionService.addPlayersToCurrentManche(session);

        session.updatePlayer(p1, new Armor(ArmorType.MAILLES));

        sessionService.playCurrentSessionManche(session);

        Assertions.assertEquals(ArmorType.GAMBISON, p1.getArmor().getArmor_type());

    }
    
}
