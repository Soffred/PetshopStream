package com.company;

import enums.Pettypes;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    public String name;
    public int age;
    public List<Pet> pets = new ArrayList<>();
    public List<Person> persons = new ArrayList<>();
    private static Random rand = new Random();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void buyPet(Pet pet) {
        pets.add(pet);
    }

    public static int ageGenerator() {
        List<Integer> ages = Arrays.asList(10, 50, 11, 22, 45, 50, 11, 28);
        int index = rand.nextInt(ages.size());
        return ages.get(index);
    }


    @Override
    public String toString() {
        if (pets.size() == 1) {
            return String.format("%s (%d) owns the %s: %s", name, age, pets.get(0).getPets(), pets.get(0).getPetName());
        } else {
            return String.format("%s (%d) owns the %s", name, age,
                    pets.stream()
                            .collect(
                                    Collectors.groupingBy(Pet::getPets)
                            )
                    .entrySet()
                    .stream()
                    .map(obj ->
                            obj.getKey() + "s: " + obj.getValue().stream().map(Pet::getPetName).collect(Collectors.joining(", "))
                    )
                    .collect(Collectors.toList())
            );
        }
    }


}





























