package com.company;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    PetStore petStore = new PetStore();
    private List<Person> personList = new ArrayList<>();



    public void run() {
        Random random = new Random();
        int nrOfPeople = random.nextInt(10) + 1;
        while (nrOfPeople-- > 0) {
            Person person = new Person(HumanNameGenerator.chooseHuman(), Person.ageGenerator());
            personList.add(person);
            int nrOfPets = random.nextInt(4) + 1;
            while (nrOfPets > 0) {
                person.buyPet(petStore.sellPet());
                nrOfPets--;
            }

        }

        personList.stream()
                    .filter(person -> person.getPets().size() > 0)
                    .sorted(Comparator.comparingInt(p -> p.getPets().size()))
                    .forEach(person -> System.out.println(person.toString()));
        }

    }


































