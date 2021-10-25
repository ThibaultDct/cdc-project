package com.api.cdcapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.api.cdcapi.business.*;
import com.api.cdcapi.business.enums.ArmorType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

@SpringBootTest
public class MancheServiceTest {

    @Autowired
    MancheService mancheService;

    @Test
    void check_number_of_manche_is_same_as_manche_number(){

        List<Team> teams = new ArrayList<>();

        List<Manche> manches = mancheService.createManches(5, teams);

        Assertions.assertEquals(5, manches.size());
    }


    
}
