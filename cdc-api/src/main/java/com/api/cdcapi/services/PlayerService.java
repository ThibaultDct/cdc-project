package com.api.cdcapi.services;

import com.api.cdcapi.business.Armor;
import com.api.cdcapi.business.Category;
import com.api.cdcapi.business.Player;
import com.api.cdcapi.business.Weapon;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    public Player createPlayer(String lastname, String firstname, Category category, Weapon weapon, Armor armor,
            int age, int seniority, boolean is_member) {
        if (age >= 16) {
            return new Player(lastname, firstname, category, weapon, armor, age, seniority, is_member);
        } else {
            return null;
        }
    }

}
