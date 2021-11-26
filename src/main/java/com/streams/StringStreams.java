package com.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStreams {

    public static void main(String[] args) throws IOException {
        //sorts a list of strings in alphabetical order, find the first String and prints it
        Stream.of("Nathan", "Agbara", "Michael")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);
        System.out.println();

        //Accepts an array of Strings, filter names that starts with S, then sort it and print
        String[] names = {"Samuel", "Peter", "Sunday", "Mathew", "Simon", "Nathan", "Michael", "Philip", "Stephen"};
        Arrays.stream(names)   //same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        //Takes a list of names, convert them to lowercase, filter by a, then print all results that starts with a
        System.out.println("Takes a list of names, convert them to lowercase, filter by a, then print all results that starts with a");
        List<String> people = Arrays.asList("Samuel", "Peter", "Sunday", "Mathew", "Simon", "Nathan", "Michael", "Philip", "Stephen", "Agbara", "Anthan", "Angular");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();

        //read rows in a file, sort it then filter by the ones whose length is greater than 13 and then println
        System.out.println("read rows in a file, sort it then filter by the ones whose length is greater than 13 and then println");
        Stream<String> celebs = Files.lines(Paths.get("C:\\Users\\agbar\\Documents\\Dev\\JavaStreams\\src\\main\\resources\\celebrities.txt"));
        celebs
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        celebs.close();
        System.out.println();

        //Stream rows from txt file and save to list
        System.out.println("Stream rows from txt file and save to list");
        List<String> celebs2 = Files.lines(Paths.get("C:\\Users\\agbar\\Documents\\Dev\\JavaStreams\\src\\main\\resources\\celebrities.txt"))
                .filter(x -> x.contains("us"))
                .collect(Collectors.toList());
        celebs2.forEach(x -> System.out.println(x));
        System.out.println();

        //Stream rows from CSV file and count
        System.out.println("Stream rows from CSV file and count");
        Stream<String> rows = Files.lines(Paths.get("C:\\Users\\agbar\\Documents\\Dev\\JavaStreams\\src\\main\\resources\\numbs.txt"));
        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows.close();
        System.out.println();

        //Stream data from CSV file, parse data from rows
        System.out.println("Stream data from CSV file, parse data from rows");
        Stream<String> rows2 = Files.lines(Paths.get("C:\\Users\\agbar\\Documents\\Dev\\JavaStreams\\src\\main\\resources\\numbs.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] +" "+x[1] +" "+x[2]));
        rows2.close();
        System.out.println();

        //Stream rows from CSV file, store fields in HashMap
        System.out.println("Stream rows from CSV file, store fields in HashMap");
        Stream<String> rows3 = Files.lines(Paths.get("C:\\Users\\agbar\\Documents\\Dev\\JavaStreams\\src\\main\\resources\\numbs.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        rows3.close();
        for (String key : map.keySet()){
            System.out.println(key +" "+map.get(key));
        }
        System.out.println();

    }
}
