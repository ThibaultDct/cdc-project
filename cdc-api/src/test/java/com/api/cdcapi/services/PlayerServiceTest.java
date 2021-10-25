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
public class PlayerServiceTest {

    @Autowired
    PlayerService service;

    @Test
    void check_player_created_with_age_over_sixteen() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 70, 10, true);

        Assertions.assertNotNull(player);

    }

    @Test
    void check_player_created_with_age_under_sixteen() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 15, 10, true);

        Assertions.assertNull(player);

    }

    @Test
    void check_player_created_with_age_equals_to_sixteen() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 16, 10, true);

        Assertions.assertNotNull(player);

    }

    @Test
    void check_player_adherent_with_age_over_sixteen() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 18, 10, true);

        Assertions.assertNotNull(player);

    }

    @Test
    void check_player_not_adherent_with_age_over_sixteen() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 24, 10, false);

        Assertions.assertNotNull(player);

    }

    @Test
    void check_player_not_adherent_with_age_under_sixteen() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 15, 10, false);

        Assertions.assertNull(player);

    }

    @Test
    void check_player_not_adherent_with_light_armor() {

        Player player = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.GAMBISON), 70, 10, false);

        Player player2 = service.createPlayer("MELENCHON", "Jean-Luc", new Category("Poids Moyen", 75, 80),
                new Weapon("Marteau"), new Armor(ArmorType.MAILLES), 70, 10, false);

        Assertions.assertNotNull(player);
        Assertions.assertEquals(ArmorType.GAMBISON, player.getArmor().getArmor_type());

        Assertions.assertNotNull(player2);
        Assertions.assertEquals(ArmorType.GAMBISON, player2.getArmor().getArmor_type());

    }

}
