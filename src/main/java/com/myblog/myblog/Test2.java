package com.myblog.myblog;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squareOfEvenNumber= numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n).collect(Collectors.toList());
        System.out.println("original Number : "+numbers);
        System.out.println("Square of Even numbers : "+squareOfEvenNumber);
    }
}
