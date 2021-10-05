package com.api.cdcapi.business;

import java.util.UUID;

public class Weapon {
    
    private UUID weapon_id;


    public Weapon() {
        this.weapon_id = UUID.randomUUID();
    }

    public UUID getWeapon_id() {
        return this.weapon_id;
    }

    public void setWeapon_id(UUID weapon_id) {
        this.weapon_id = weapon_id;
    }

    
}
