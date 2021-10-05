package com.api.cdcapi.business;

import java.util.UUID;

public class Player {
    
    private UUID player_id;
    private String lastname;
    private String firstname;
    private Category category;
    private Weapon weapon;
    private Armor armor;
    private int age;
    private int seniority;
    private boolean is_member;


    public Player(){}


    public Player(String lastname, String firstname, Category category, Weapon weapon, Armor armor, int age, int seniority, boolean is_member) {
        this.player_id = UUID.randomUUID();
        this.lastname = lastname;
        this.firstname = firstname;
        this.category = category;
        this.weapon = weapon;
        this.armor = armor;
        this.age = age;
        this.seniority = seniority;
        this.is_member = is_member;
    }


    public UUID getPlayer_id() {
        return this.player_id;
    }

    public void setPlayer_id(UUID player_id) {
        this.player_id = player_id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeniority() {
        return this.seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public boolean isIs_member() {
        return this.is_member;
    }

    public boolean getIs_member() {
        return this.is_member;
    }

    public void setIs_member(boolean is_member) {
        this.is_member = is_member;
    }


    

}
