package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<List<Integer>>> twiceNestedList = Arrays.asList(
                Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5)),
                Arrays.asList(Arrays.asList(6), Arrays.asList(7, 8, 9))
        );

        List<List<Integer>> nestedList = twiceNestedList.stream()
                .map(
                        lists -> lists.stream()
                                .flatMap(innerList -> innerList.stream())
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(nestedList);
    }
}
