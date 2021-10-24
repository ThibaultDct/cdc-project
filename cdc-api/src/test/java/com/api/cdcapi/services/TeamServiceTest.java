package com.api.cdcapi.services;

import com.api.cdcapi.business.*;
import com.api.cdcapi.business.enums.ArmorType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TeamServiceTest {

    @Autowired
    TeamService service;

    @Test
    void check_teams_created_have_the_same_number_of_players_when_size_is_even() {
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));

        Team team1 = new Team();
        Team team2 = new Team();

        service.createTeams(team1, team2, players);

        Assertions.assertEquals(2, team1.getPlayers().size());
        Assertions.assertEquals(2, team2.getPlayers().size());
    }

    @Test
    void check_teams_created_have_the_same_number_of_players_when_size_is_not_even() {
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        players.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));
        players.add(new Player("MACRON", "Emmanuel", new Category("Poids Super-Lourd", 91, 100), new Weapon("Taxes"), new Armor(ArmorType.GAMBISON), 99, 0, false));

        Team team1 = new Team();
        Team team2 = new Team();

        service.createTeams(team1, team2, players);

        Assertions.assertEquals(3, team1.getPlayers().size());
        Assertions.assertEquals(2, team2.getPlayers().size());
    }

    @Test
    void check_team_weight_mean_all_equals() {
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 75, 80), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 75, 80), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));

        Team team = new Team(players);

        Assertions.assertEquals(80, team.getPlayersWeightMean());
    }

    @Test
    void check_team_weight_mean_all_not_equals() {
        List<Player> players = new ArrayList<>();

        players.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 40, 60), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        players.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 40, 70), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        players.add(new Player("MOREL", "Alban", new Category("Poids Plume", 40, 80), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));

        Team team = new Team(players);

        Assertions.assertEquals(70, team.getPlayersWeightMean());
    }

}
