package com.api.cdcapi.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.api.cdcapi.business.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;

@Service
public class MancheService {

    public List<Manche> createManches(Integer manchesNumber, List<Team> teams){
        List<Manche> manches = new ArrayList<>();

        for (int i = 0; i < manchesNumber; i++) {
            manches.add(new Manche(teams, i));     
        }
        return manches;        
    }
    
}
