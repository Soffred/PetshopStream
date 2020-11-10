package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class  PetNameGenerator {
    public static List<String> nameList;
    public static Random random;

    static {
        random = new Random();
        try {
            nameList = Files.lines(Paths.get("pet-names-4.txt"))
                    .flatMap(s ->
                            Stream.of(s.split(", "))
                    )
                    .flatMap(s ->
                            Stream.of(s.split("\\d")))
                    .flatMap(s ->
                            Stream.of(s.split("\\.")))
                    .flatMap(s ->
                            Stream.of(s.split("\"")))
                    .flatMap(s ->
                            Stream.of(s.split("\\s+"))
                    )
                    .sorted()
                    .filter(s -> !s.equals(""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public PetNameGenerator() {
    }


    public static String choosePetName(){
        int index = random.nextInt(nameList.size());
        String name = nameList.get(index);
        nameList.remove(index);
        return name;
    }



}










