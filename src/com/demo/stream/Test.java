package com.demo.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(10,10,15,8,49,25,98,32,12,101,99,102);
//        list.stream()
//                .collect(Collectors.toMap(Function.identity(), Function.identity(), (o1, o2) -> o1));
//        System.out.println(collect);
//        list.stream()
//                .filter(num -> num%2==0)
//                .forEach(System.out::println);

//        list.stream()
//                .map(num -> num.toString())
//                .filter(s -> s.startsWith("1"))
//                .forEach(System.out::println);

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
//        Set<Integer> set = new HashSet<>();
//        myList.stream()
//                .filter(num->!(set.add(num)))
//                .forEach(System.out::println);

        String input = "ava articles are Awesome";

        IntStream chars = input.chars();
        Stream<Character> characterStream = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c));
        Character c1 = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst()
                .get();
//        System.out.println(c1);

    }
}
