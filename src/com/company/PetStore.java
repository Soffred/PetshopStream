package com.company;


public class PetStore  {
    private static int nrOfPets = 100;

    public PetStore() {

    }

    public static Pet sellPet() {
        nrOfPets--;
      return new Pet (PetNameGenerator.choosePetName());

    }

}







