package com.api.cdcapi.business;

import java.util.UUID;

import com.api.cdcapi.business.enums.ArmorType;

public class Armor {
    
    private UUID armor_id;
    private ArmorType armor_type;


    public Armor() {
    }

    public Armor(ArmorType armor_type) {
        this.armor_id = UUID.randomUUID();
        this.armor_type = armor_type;
    }

    public UUID getArmor_id() {
        return this.armor_id;
    }

    public void setArmor_id(UUID armor_id) {
        this.armor_id = armor_id;
    }

    public ArmorType getArmor_type() {
        return this.armor_type;
    }

    public void setArmor_type(ArmorType armor_type) {
        this.armor_type = armor_type;
    }

    @Override
    public String toString() {
        return this.armor_type.toString();
    }

}
