package com.company;
import enums.Pettypes;
import enums.Pettypes;

import java.util.Random;



public class Pet {
    public String petName;
    private static Random random = new Random();
    private String pets = Pettypes.values()[random.nextInt(Pettypes.values().length)].toString();


    public Pet(String petName) {
        this.petName = petName;

    }

    public String getPetName(){
        return petName;
    }


    public String getPets(){
        return pets;
    }


}












