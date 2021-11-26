package com.streams;

import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStream {

    public static void main(String[] args) throws IOException {
        //pints a list of integers from 1 through 9 using the integer stream
        IntStream
                .range(1,10)
                .forEach(System.out::print);
        System.out.println();

        //Accepts a list of integers 1 to 9, skip 1 to 5 and prints a list of integers 6 through 9
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();

        //this is going to print the sum of integers 1 to 5
        System.out.println(
                IntStream
                        .range(1,5)
                        .sum());
        System.out.println();

        //Average of squares of an int []
        System.out.println("Average of squares of an int []");
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::print);
        System.out.println();

        //Reduction - sum
        System.out.println("Reduction - Sum");
        double total = Stream.of(7.3, 1.5, 6.5)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = "+total);
        System.out.println();

        //Reduction - summary statistics (this only works for integers)
        System.out.println("Reduction - summary statistics");
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 50, 99, 80, 4, 5)
                .summaryStatistics();
        System.out.println(summary);
    }
}
