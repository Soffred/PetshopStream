package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class HumanNameGenerator {
    public static Random random;
    public static List<String> humanList;
    static {
        random = new Random();
        try {
            humanList = Files.lines(Paths.get("human-names.txt"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HumanNameGenerator() {
    }

    public static String chooseHuman(){
        int index = random.nextInt(humanList.size());
        return humanList.remove(index);
    }
}
