package com.questions;

import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OddFrequency {
    public static void main(String[] args) {
        String str = "zzzaaaayyyybbbbxxrrrrxrcccccapppa";

        List<Character> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        TreeMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
