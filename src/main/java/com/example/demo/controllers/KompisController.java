package com.example.demo.controllers;

import com.example.demo.models.Kompis;
import com.example.demo.repos.DAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-08
 * Time: 14:49
 * Project: demo01
 * Copyright: MIT
 */
@RestController
public class KompisController {

    DAO db = new DAO();
    List<Kompis> myKompisar = db.getAllKompisar();

    //returnera random kompis
    @RequestMapping("/kompis")
    public Kompis kompis(){

        Random rand = new Random();
        int numberOfElements = 1;
        Kompis randomElement = null;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(myKompisar.size());
            randomElement = myKompisar.get(randomIndex);
            return randomElement;
        }
        return randomElement;
    }

    //returnera alla kompisar
    @RequestMapping("/kompisar")
    public List<Kompis> kompisar(){
        return myKompisar;
    }


    //returnera en specifik kompis med id
    @RequestMapping("/kompis/{id}")
    public Kompis kompisById (@PathVariable int id){
        for (Kompis k : myKompisar){
            if (k.getId() == id){
                return k;
            }
        }
        return null;
    }


    //deleta en särskild kompis mha id
    @RequestMapping("/kompis/{id}/delete")
    public String deleteKompisById(@PathVariable int id){
    int indexToRemove = -1;

        for (int i = 0; i < myKompisar.size(); i++) {
            if (myKompisar.get(i).getId() == id){
                indexToRemove = i;
            }
        }
        myKompisar.remove(indexToRemove);
        return "Kompisen med id " + id + " är borttagen";

        }

    //via postman, add kompis (funkar m. linkedlist)
    @PostMapping("/kompis/add")
    public String addKompis (@RequestBody Kompis k){
        myKompisar.add(k);
        return "kompis added";
    }

    //via postman, upsert kompis (funkar m. linkedlist)
    @PostMapping("/kompis/upsert")
    public String upsertKompis (@RequestBody Kompis k){
        int indexToUpdate = -1;

        for (int i = 0; i < myKompisar.size(); i++) {
            if (myKompisar.get(i).getId() == k.getId()){
                indexToUpdate = i;
            }
        }
        if (indexToUpdate == -1){
            myKompisar.add(k);
        }
        else {
            myKompisar.set(indexToUpdate, k);
        }
        return "kompis added";
    }




}
