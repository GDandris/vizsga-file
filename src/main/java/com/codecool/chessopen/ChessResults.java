package com.codecool.chessopen;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            Map<String, Integer> competitors = new HashMap<>();
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(",");
                String name = line[0];
                int points = (Integer.parseInt(line[1]) + Integer.parseInt(line[2])
                        + Integer.parseInt(line[3]) + Integer.parseInt(line[4]) + Integer.parseInt(line[5]));
                competitors.put(name, points);
            }
            myReader.close();
            return competitors.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return null;
        }
    }
}
