package com.api.cdcapi.business;

import java.util.UUID;

public class Weapon {
    
    private UUID weapon_id;
    private String label;

    public Weapon(String label) {
        this.weapon_id = UUID.randomUUID();
        this.label = label;
    }

    public UUID getWeapon_id() {
        return this.weapon_id;
    }

    public void setWeapon_id(UUID weapon_id) {
        this.weapon_id = weapon_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
        return this.label;
    }

    
}
