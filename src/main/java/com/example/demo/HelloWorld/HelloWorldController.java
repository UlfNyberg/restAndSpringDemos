package com.example.demo.HelloWorld;

import com.example.demo.models.Kompis;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-08
 * Time: 10:57
 * Project: demo01
 * Copyright: MIT
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index (){
        return "Hello World!";
    }

    @RequestMapping("/a")
    public String index2 (){
        return "Tja World!";
    }

    @RequestMapping("/hello")
    public String defaultHello (@RequestParam (defaultValue = "Ulf") String name){
        return "Hej " + name;
    }

    //returnera antingen number eller animal, random
    @RequestMapping("/luckyYou")
    public String luckyYou (@RequestParam String reply) {
        Random rand = new Random();
        String randomElement = "funkar det?";
        if (reply.equals("animal")) {
            List<String> givenList = Arrays.asList("hund", "katt", "spindel", "häst");

            int numberOfElements = 1;
            //String randomElement = "";

            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(givenList.size());
                randomElement = givenList.get(randomIndex);
                return randomElement;
            }
        }
        if (reply.equals("number")) {
            int min = 1;
            int max = 10;

            Random random = new Random();

            int value = random.nextInt(max + min) + min;
            //return String.valueOf(value);
            randomElement = String.valueOf(value);
        }
        return randomElement;
    }

    //få in namn
    @RequestMapping("/hej3")
    public String hej3 ( @RequestParam List<String> names){
        return "Hello " + names;
    }

    //få in ett namn
    @RequestMapping("/hejPathParam/{name}")
    public String hejPathParam (@PathVariable String name){
        if (name == null) return "Hello World";
        return "Hello " + name;
    }





}
